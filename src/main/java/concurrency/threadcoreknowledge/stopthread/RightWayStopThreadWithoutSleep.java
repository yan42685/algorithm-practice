package concurrency.threadcoreknowledge.stopthread;

import utils.ThreadUtils;


public class RightWayStopThreadWithoutSleep {
    public static void main(String[] args) {
        Runnable task = () -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE) {
                if (num % 10000 == 0) {
                    System.out.println(num);
                }
                num++;
            }
            System.out.println("任务完成");
        };

        Thread thread = new Thread(task);
        thread.start();
        ThreadUtils.sleepSeconds(1);
        // 通知该线程中断
        thread.interrupt();
    }
}