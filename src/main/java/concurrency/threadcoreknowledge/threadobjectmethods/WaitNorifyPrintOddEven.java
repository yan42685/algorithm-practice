package concurrency.threadcoreknowledge.threadobjectmethods;

import utils.ThreadUtils;

public class WaitNorifyPrintOddEven {
    private static int count = 0;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            while (count <= 100) {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                    LOCK.notify();
                    // 打印完后不再休眠
                    if (count <= 100) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        new Thread(task, "偶数").start();
        // 先start的不一定先执行，所以需要等待一会儿
        ThreadUtils.sleepMillis(100);
        new Thread(task, "奇数").start();

    }
}
