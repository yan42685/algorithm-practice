package design_pattern.behavioural.observer;

import java.util.concurrent.Executor;

/**
 * 提供同步执行服务, 定义这个类是为了调用代码的一致性
 */
public class BlockedExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
