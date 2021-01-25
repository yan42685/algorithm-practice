package design_pattern.behavioural.state.finite_state_machine.test;

import design_pattern.behavioural.observer.EventBus;
import design_pattern.behavioural.state.finite_state_machine.StateMachine;

public class Test {
    public static void main(String[] args) {
        StateMachine stateMachine = StateMachineFactory.create();
        EventBus eventBus = new EventBus();
        eventBus.register(stateMachine);
        eventBus.emit(RandomEvent.EAT);
        eventBus.emit(RandomEvent.STARVE);
    }
}
