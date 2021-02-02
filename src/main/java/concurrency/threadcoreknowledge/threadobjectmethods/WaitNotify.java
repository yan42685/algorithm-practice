package concurrency.threadcoreknowledge.threadobjectmethods;

import utils.ThreadUtils;

/**
 * 1. wait 和 notify 的用法
 * 2. 证明 wait 释放锁
 */
public class WaitNotify {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(WaitNotify::task1);
        Thread thread2 = new Thread(WaitNotify::task2);
        thread1.start();
        ThreadUtils.sleepSeconds(1);
        thread2.start();
    }

    private static void task1() {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + "开始");
            try {
                System.out.println(Thread.currentThread().getName() + " wait() 释放锁，进入WAITING状态");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取锁, 进入 RUNNABLE 状态");
        }
        ;
    }

    private static void task2() {
        synchronized (LOCK) {
            LOCK.notify();
            System.out.println(Thread.currentThread().getName() + "调用了notify()");
            ThreadUtils.sleepMillis(100);
            System.out.println(Thread.currentThread().getName() + " notify()不会释放锁，该线程会继续运行直到run方法结束或线程等待、阻塞");
        }
        ;
    }
}
