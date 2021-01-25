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

        Transition eatTransition = new Transition(greatState, RandomEvent.EAT, event -> log.info("触发事件：{}", event.getName()));
        Transition starveTransition2 = new Transition(smallState, RandomEvent.STARVE, event -> log.info("触发事件：{}", event.getName()));
        Transition starveTransition = new Transition(normalState, RandomEvent.STARVE, event -> log.info("触发事件：{}", event.getName()));

        normalState.addTransition(eatTransition)
                .addTransition(starveTransition2);

        greatState.addTransition(starveTransition);
        return new StateMachine(normalState);
    }
}
