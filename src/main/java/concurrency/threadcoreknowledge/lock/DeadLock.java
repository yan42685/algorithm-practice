package concurrency.threadcoreknowledge.lock;

import utils.ThreadUtils;

public class DeadLock {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + "获取LOCK_A");
                ThreadUtils.sleepMillis(100);
                synchronized (LOCK_B) {
                    System.out.println(Thread.currentThread().getName() + "获取LOCK_B");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (LOCK_B) {
                System.out.println(Thread.currentThread().getName() + "获取LOCK_B");
                ThreadUtils.sleepMillis(100);
                synchronized (LOCK_A) {
                    System.out.println(Thread.currentThread().getName() + "获取LOCK_A");
                }
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

    }
}
