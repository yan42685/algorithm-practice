package design_pattern.behavioural.strategy;

public interface IStrategy {
    void say();
}

@Strategy(type = StrategyType.TYPE_A)
class StrategyA implements IStrategy {
    @Override
    public void say() {
        System.out.println("This is strategy A");
    }
}

@Strategy(type = StrategyType.TYPE_B)
class StrategyB implements IStrategy {
    @Override
    public void say() {
        System.out.println("This is strategy B");
    }
}

