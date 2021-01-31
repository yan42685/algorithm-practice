package concurrency.threadcoreknowledge.stopthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 最佳实践 (传递中断)：优先在方法签名中抛出 中断异常,
 * 这样可以让调用者自己处理异常
 */
@Slf4j
public class BestPracticeStopThread1 {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                methodWithException();
            } catch (InterruptedException e) {
                log.error("保存日志");
                e.printStackTrace();
            }
        };
        new Thread(task).start();
    }

    private static void methodWithException() throws InterruptedException {
        // do something...
        Thread.sleep(1);
        // do something...
    }
}
