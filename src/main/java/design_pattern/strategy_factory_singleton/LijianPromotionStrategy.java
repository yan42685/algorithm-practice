package design_pattern.strategy_factory_singleton;

/**
 * @author alexyan
 */
public class LijianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("立减促销策略");
    }
}
