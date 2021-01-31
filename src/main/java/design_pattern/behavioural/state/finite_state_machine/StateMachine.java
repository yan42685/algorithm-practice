package design_pattern.behavioural.state.finite_state_machine;

import design_pattern.behavioural.observer.Subscribe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import utils.Lambda;

import java.util.Optional;

@Slf4j
public class StateMachine {
    @Getter
    private State currentState;

    public StateMachine(State initialState) {
        this.currentState = initialState;
        // 可以理解成最简单的模板方法
        log.info("状态机启动");
    }

    @Subscribe
    private void onEvent(IEvent event) {
        Optional<Transition> theTransition = Lambda.findFirst(currentState.getAllTransitions(),
                transition -> transition.getEventName().equals(event.getName()));

        theTransition.ifPresent(transition -> {
            transition.handleEvent(event);
            this.currentState = transition.getTarget();
        });
    }

}
