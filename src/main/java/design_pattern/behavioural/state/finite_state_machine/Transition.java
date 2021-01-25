package design_pattern.behavioural.state.finite_state_machine;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Consumer;

@EqualsAndHashCode
@Builder
public class Transition {
    // @NonNull用于build()时的校验
    @NonNull
    @Getter
    private final String eventName;
    @NonNull
    @Getter
    private final State target;
    @NonNull
    private final Consumer<TransitionEvent> handler;

    public void handleEvent(TransitionEvent transitionEvent) {
        handler.accept(transitionEvent);
    }
}
