package design_pattern.behavioural.strategy;

import java.lang.annotation.*;

/**
 * 标记一个策略类的类型, 然后由反射自动注册到 StrategyFactory 里
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Strategy {
    StrategyType type();
}
