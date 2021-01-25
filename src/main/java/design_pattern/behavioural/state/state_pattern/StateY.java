package design_pattern.behavioural.state.state_pattern;

public class StateY extends AbstractState {
    public StateY(Context context) {
        this.context = context;
    }


    @Override
    public void onEventOne() {

    }

    @Override
    public void onEventTwo() {
        System.out.println("from stateY to StateX on EventTwo");
        // NOTE: 这里的状态还可以用工厂模式进一步优化
        context.setCurrentState(context.getStateX());
        System.out.println("handle EventTwo");
        // 依赖stateMachine
        context.addScore(99);
    }
}
