package design_pattern.behavioural.state.finite_state_machine.test;

import design_pattern.behavioural.state.finite_state_machine.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleState implements StateType {
    NORMAL("正常"),
    GREAT("放大化"),
    SMALL("缩小化");

    private final String value;
}
