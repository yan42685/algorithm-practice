package concurrency.threadcoreknowledge.uncaughtexceptionhandler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 处理子线程内的异常
 * 可以用于整个程序、每个线程、线程池分别设置
 */
public class MyUncaughtExceptionHandler {
    public static void main(String[] args) {
        UncaughtExceptionHandler exceptionHandler = (thread, exception) -> System.out.println("自定义处理器：处理子线程异常");
        Runnable task = () -> {
            throw new RuntimeException();
        };

        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(exceptionHandler);
        thread.start();

        System.out.println("主线程会继续执行");
    }
}
