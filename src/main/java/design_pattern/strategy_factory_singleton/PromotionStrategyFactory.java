package design_pattern.strategy_factory_singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexyan
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> promotionStrategyMap = new HashMap<>();

    static {
        promotionStrategyMap.put(StrategyKey.FANXIAN, new FanxianPromotionStrategy());
        promotionStrategyMap.put(StrategyKey.LIJIAN, new LijianPromotionStrategy());
        promotionStrategyMap.put(StrategyKey.MANJIAN, new ManjianPromotionStrategy());
    }

    private static final PromotionStrategy NO_PROMOTION = new EmptyPromotionStrategy();

    private PromotionStrategyFactory() {
    }

    private interface StrategyKey {
        String FANXIAN = "fanxian";
        String LIJIAN = "lijian";
        String MANJIAN = "manjian";
    }

    public static PromotionStrategy getStrategy(String strategyKey) {
        return strategyKey == null ? NO_PROMOTION : promotionStrategyMap.get(strategyKey);
    }
}
