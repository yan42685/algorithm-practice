package design_pattern.behavioural.state.state_pattern;

public class StateX extends AbstractState {
    public StateX(Context context) {
        this.context = context;
    }

    @Override
    public void onEventOne() {
        System.out.println("from stateX to StateY on EventOne");
        // NOTE: 这里的状态还可以用工厂模式进一步优化
        context.setCurrentState(context.getStateY());
        System.out.println("handle EventOne");
        // 依赖stateMachine
        context.addScore(3);
    }

    @Override
    public void onEventTwo() {
    }
}
