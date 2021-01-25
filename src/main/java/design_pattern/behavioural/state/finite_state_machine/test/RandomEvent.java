package design_pattern.behavioural.state.finite_state_machine.test;

import design_pattern.behavioural.state.finite_state_machine.TransitionEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RandomEvent implements TransitionEvent {
    EAT("吃"),
    STARVE("挨饿"),
    STARVE_HEAVILY("极度挨饿");

    private final String name;
}
