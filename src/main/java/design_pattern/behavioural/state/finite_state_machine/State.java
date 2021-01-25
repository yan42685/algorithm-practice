package design_pattern.behavioural.state.finite_state_machine;

import lombok.Getter;
import utils.Asserts;

import java.util.ArrayList;
import java.util.List;

public class State {
    @Getter
    private final IState type;
    @Getter
    private final List<Transition> allTransitions = new ArrayList<>();

    public State(IState type) {
        this.type = type;
    }

    public State addTransition(Transition transition) {
        allTransitions.forEach(oldTransition -> {
            Asserts.isFalse(oldTransition.getEventName().equals(transition.getEventName()),
                    "同一状态不能添加相同name的transition");
            Asserts.isFalse(oldTransition.getTarget().equals(transition.getTarget()),
                    "同一状态不能添加相同target的transition");
        });
        allTransitions.add(transition);
        return this;
    }
}
