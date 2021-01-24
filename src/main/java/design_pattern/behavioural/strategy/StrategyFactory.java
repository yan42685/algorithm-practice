package design_pattern.behavioural.strategy;

import utils.Asserts;
import utils.ReflectionUtils;

import java.util.*;

/**
 * 用 map 替代 if 进行具体策略对象的选择
 * 符合开闭原则， 添加策略时只需要增加一个 type 和 实现类 即可，不必修改 Factory
 * <p>
 * 和简单工厂模式的区别在于： 对象是缓存在map中的，而不是每次都创建新的
 */
public class StrategyFactory {
    private static final Map<StrategyType, IStrategy> strategyMap = new HashMap<>();

    static {
        registerStrategy();
    }

    public static IStrategy get(StrategyType type) {
        IStrategy strategy = strategyMap.get(type);
        Asserts.nonNull(strategy);
        return strategy;
    }

    /**
     * 运行时注册同一个包下的所有策略
     */
    private static void registerStrategy() {
        // 获取策略接口的所有实现类, 依赖 Reflections 框架
        Set<Class<? extends IStrategy>> strategyClasses = ReflectionUtils.getSubClassesFromSamePackage(IStrategy.class);

        // 注册所有实现类
        Optional.ofNullable(strategyClasses).orElse(new HashSet<>()).stream()
                .filter(clazz -> clazz.isAnnotationPresent(Strategy.class))
                .forEach(clazz -> {
                    StrategyType type = clazz.getAnnotation(Strategy.class).type();
                    if (strategyMap.containsKey(type)) {
                        throw new RuntimeException(String.format("%s 类重复注册策略 %s", clazz.getCanonicalName(), type));
                    } else {
                        try {
                            strategyMap.put(type, clazz.newInstance());
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
