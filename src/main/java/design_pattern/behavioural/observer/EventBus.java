package design_pattern.behavioural.observer;

import java.util.concurrent.Executor;

/**
 * 面向用户
 * 观察者模式和发布订阅模式的区别在于，观察者模式的被观察者需要知道被哪些类观察，轻微耦合，而发布订阅都只知道 Event流
 * 这里代码参考了 Guava 的 EventBus
 */
public class EventBus {
    private final Executor executor;
    // listener注册中心
    private final ListenerRegistry registry = new ListenerRegistry();

    public EventBus(Executor executor) {
        // 用户提供Executor, 一般是异步的
        this.executor = executor;
    }

    public EventBus() {
        // 默认的同步Executor
        this.executor = new BlockedExecutor();
    }

    public void register(Object listener) {
        registry.register(listener);
    }

    public void emit(Object event) {
        registry.getMatchedHandlers(event)
                .forEach(handler -> {
                            System.out.println("hahah");
                            executor.execute(() -> handler.handle(event));
                        }
                );
    }

}
