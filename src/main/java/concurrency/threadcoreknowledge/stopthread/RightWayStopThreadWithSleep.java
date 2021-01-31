package concurrency.threadcoreknowledge.stopthread;

import utils.ThreadUtils;

public class RightWayStopThreadWithSleep {
    public static void main(String[] args) {
        Runnable task = () -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num < 400) {
                if (num % 100 == 0) {
                    System.out.println(num);
                }
                num++;
            }
            ThreadUtils.sleepMillis(1000);
            System.out.println("任务完成");
        };

        Thread thread = new Thread(task);
        thread.start();
        ThreadUtils.sleepMillis(500);
        // 通知该线程中断
        thread.interrupt();
    }
}
