package design_pattern.strategy_factory_singleton;

/**
 * @author alexyan
 */
public class FanxianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销策略");
    }
}
