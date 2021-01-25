package design_pattern.behavioural.state.finite_state_machine.test;

import design_pattern.behavioural.state.finite_state_machine.State;
import design_pattern.behavioural.state.finite_state_machine.StateMachine;
import design_pattern.behavioural.state.finite_state_machine.Transition;

/**
 * 定义具体 StateMachine 的状态及转移规则
 */
public class StateMachineFactory {
    public static StateMachine create() {
        State greatState = new State(RoleState.GREAT);
        State normalState = new State(RoleState.NORMAL);
        State smallState = new State(RoleState.SMALL);

        Transition eatTransition = Transition.builder()
                .source(normalState)
                .target(greatState)
                .eventName(RandomEvent.EAT.getName())
                // 后期可以重构为发布订阅模式
                .handler(event -> System.out.printf("触发事件：%s\n", event.getName()))
                .build();

        Transition starveTransition = Transition.builder()
                .source(greatState)
                .target(normalState)
                .eventName(RandomEvent.STARVE.getName())
                .handler(event -> System.out.printf("触发事件: %s\n", event.getName()))
                .build();

        normalState.addTransition(eatTransition);
        greatState.addTransition(starveTransition);
        return new StateMachine(normalState);
    }
}
