package design_pattern.behavioural.state.finite_state_machine.test;

import design_pattern.behavioural.state.finite_state_machine.State;
import design_pattern.behavioural.state.finite_state_machine.StateMachine;
import design_pattern.behavioural.state.finite_state_machine.Transition;
import lombok.extern.slf4j.Slf4j;

/**
 * 定义具体 StateMachine 的状态及转移规则
 */
@Slf4j
public class StateMachineFactory {
    public static StateMachine create() {
        State greatState = new State(RoleState.GREAT);
        State normalState = new State(RoleState.NORMAL);
        State smallState = new State(RoleState.SMALL);

        // TODO: 用注解实现注册状态
        Transition eatTransition = Transition.builder()
                .target(greatState)
                .eventName(RandomEvent.EAT.getName())
                // 后期可以重构为发布订阅模式
                .handler(event -> log.info("触发事件：{}", event.getName()))
                .build();

        Transition starveTransition = Transition.builder()
                .target(normalState)
                .eventName(RandomEvent.STARVE.getName())
                .handler(event -> log.info("触发事件: {}\n", event.getName()))
                .build();

        normalState.addTransition(eatTransition);
        greatState.addTransition(starveTransition);
        return new StateMachine(normalState);
    }
}
