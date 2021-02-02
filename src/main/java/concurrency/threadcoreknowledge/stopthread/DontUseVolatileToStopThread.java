package concurrency.threadcoreknowledge.stopthread;

import utils.ThreadUtils;

public class DontUseVolatileToStopThread {
    private volatile static boolean isInterrupted = false;

    public static void main(String[] args) throws InterruptedException {
        testInterrupt();
    }

    /**
     * 不会走while里的条件，而是一直阻塞
     */
    private static void testVolatile() {
        Runnable task = () -> {
            while (!isInterrupted) {
                try {
                    System.out.println("开始睡眠");
                    // 模拟线程阻塞
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(task).start();
        ThreadUtils.sleepSeconds(2);
        System.out.println("中断睡眠");
        isInterrupted = true;
    }

    /**
     * 响应中断，按预期进行处理
     */
    private static void testInterrupt() {
        Runnable task = () -> {
            while (true) {
                System.out.println("开始睡眠");
                try {
                    // 模拟线程阻塞
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        ThreadUtils.sleepSeconds(2);
        System.out.println("中断睡眠");
        thread.interrupt();
    }
}

