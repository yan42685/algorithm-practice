package design_pattern.strategy_factory_singleton;

/**
 * @author alexyan
 */
public class PromotionActivity {
    public static void main(String[] args) {
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getStrategy("manjian");
        promotionStrategy.doPromotion();
    }
}
