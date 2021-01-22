package design_pattern.strategy_factory_singleton;

/**
 * @author alexyan
 */
public class ManjianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("满减促销策略");
    }
}
