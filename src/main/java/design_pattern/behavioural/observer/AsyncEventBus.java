package design_pattern.behavioural.observer;

import java.util.concurrent.Executor;

/**
 * 面向用户
 * 定义此类只是为了让语义看起来更清晰
 * 构造方法不提供同步的 EventBus了
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
