package design_pattern.behavioural.state.finite_state_machine;

import lombok.Getter;
import utils.Asserts;

import java.util.HashSet;
import java.util.Set;

public class State {
    @Getter
    private StateType type;
    @Getter
    private Set<Transition> allTransitions = new HashSet<>();

    public State(StateType type) {
        this.type = type;
    }

    public State addTransition(Transition transition) {
        allTransitions.forEach(oldTransition -> {
            Asserts.isFalse(oldTransition.getEventName().equals(transition.getEventName()),
                    "同一状态不能添加相同名字的transition");
        });
        allTransitions.add(transition);
        return this;
    }
}