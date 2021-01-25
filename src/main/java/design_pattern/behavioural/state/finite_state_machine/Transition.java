package design_pattern.behavioural.state.finite_state_machine;

import lombok.Getter;

import java.util.function.Consumer;

public class Transition {
    @Getter
    private final String eventName;
    @Getter
    private final State target;
    private final Consumer<IEvent> handler;

    public Transition(State target, IEvent event, Consumer<IEvent> handler) {
        this.eventName = event.getName();
        this.target = target;
        this.handler = handler;
    }

    public void handleEvent(IEvent event) {
        handler.accept(event);
    }
}
