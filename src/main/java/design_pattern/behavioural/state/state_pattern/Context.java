package design_pattern.behavioural.state.state_pattern;

import lombok.Getter;
import utils.AtomicUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Context 和 AbstractState双向依赖
 */
public class Context {
    private final AtomicInteger score;
    // 依赖AbstractState
    @Getter
    private AbstractState currentState;
    // 用this而不是new Context() 避免循环依赖
    @Getter
    private final StateX stateX = new StateX(this);
    @Getter
    private final StateY stateY = new StateY(this);

    public Context() {
        this.score = new AtomicInteger(0);
        this.currentState = stateX;
    }

    public void setCurrentState(AbstractState state) {
        this.currentState = state;
    }

    public void addScore(int delta) {
        AtomicUtils.addInt(this.score, delta);
    }

    public void reduceScore(int delta) {
        AtomicUtils.reduceInt(this.score, delta);
    }

    public void onEventOne() {
        currentState.onEventOne();
    }

    public void onEventTwo() {
        currentState.onEventTwo();
    }

    public void onEventThree() {
        currentState.onEventThree();
    }

}
