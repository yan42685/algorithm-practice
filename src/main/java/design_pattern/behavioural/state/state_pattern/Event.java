package design_pattern.behavioural.state.state_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Event {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3);

    private int value;
}
