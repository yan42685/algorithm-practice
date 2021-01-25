package design_pattern.behavioural.state.finite_state_machine;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Consumer;

@EqualsAndHashCode
// 指定重写的方法名
@Builder
public class Transition {
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
