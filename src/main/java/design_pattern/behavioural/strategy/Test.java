package design_pattern.behavioural.strategy;

public class Test {
    public static void main(String[] args) {
        IStrategy strategyA = StrategyFactory.get(StrategyType.TYPE_A);
        IStrategy strategyB = StrategyFactory.get(StrategyType.TYPE_B);
        strategyA.say();
        strategyB.say();
    }
}
