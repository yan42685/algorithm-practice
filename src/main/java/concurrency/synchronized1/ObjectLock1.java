package concurrency.synchronized1;

import utils.ThreadUtils;

public class ObjectLock1 implements Runnable {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        ObjectLock1 instance = new ObjectLock1();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "  lock1开始");
            ThreadUtils.sleepSeconds(2);
            System.out.println(Thread.currentThread().getName() + "  lock1结束");
        }

        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "  lock2开始");
            ThreadUtils.sleepSeconds(2);
            System.out.println(Thread.currentThread().getName() + "  lock2结束");
        }
    }
}
