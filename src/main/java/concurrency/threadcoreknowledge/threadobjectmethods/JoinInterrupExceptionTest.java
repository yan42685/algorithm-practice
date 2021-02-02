package concurrency.threadcoreknowledge.threadobjectmethods;

import utils.ThreadUtils;

public class JoinInterrupExceptionTest {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Runnable task = () -> {
            ThreadUtils.sleepMillis(300);
            mainThread.interrupt();
        };
        Thread thread = new Thread(task);
        thread.start();
        ThreadUtils.join(thread);
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("主线程被中断了");
        }

    }
}
