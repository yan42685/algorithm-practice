package design_pattern.behavioural.state.state_pattern;

/**
 * 使用抽象类而不是接口的原因:
 * 1. 可以让子类不必重复定义stateMachine,
 * 2. 抽象方法规定所有子类必须实现， 又能提供默认的抛出异常的方法让子类选择性实现（这样添加面向用户的接口就不必每个子类都实现）
 */
public abstract class AbstractState {
    protected Context context;

    public abstract void onEventOne();

    public abstract void onEventTwo();

    // 不要求子类一定实现，但是对外提供这个接口
    public void onEventThree() {
        throw new RuntimeException("方法未实现");
    }
}
