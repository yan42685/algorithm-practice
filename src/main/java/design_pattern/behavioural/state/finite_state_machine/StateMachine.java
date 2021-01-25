package design_pattern.behavioural.state.finite_state_machine;

import design_pattern.behavioural.observer.Subscribe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import utils.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class StateMachine {
    private List<State> allStates = new ArrayList<>();
    @Getter
    private State currentState;

    public StateMachine(State initialState) {
        this.currentState = initialState;
        // 可以理解成最简单的模板方法
        log.info("状态注册成功");
    }

    @Subscribe
    private void onEvent(TransitionEvent event) {
        Optional<Transition> theTransition = Lambda.findOne(currentState.getAllTransitions(),
                transition -> transition.getEventName().equals(event.getName()));

        theTransition.ifPresent(transition -> {
            transition.handleEvent(event);
            this.currentState = transition.getTarget();
        });
    }

    public StateMachine addState(State state) {
        allStates.add(state);
        return this;
    }
}
