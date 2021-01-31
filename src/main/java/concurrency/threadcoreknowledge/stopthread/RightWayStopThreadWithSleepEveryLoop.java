package concurrency.threadcoreknowledge.stopthread;

import utils.ThreadUtils;

public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) {
        Runnable task = () -> {
            int num = 0;
            // 如果每轮循环末尾都有睡眠则不必判断是否处于interrupted状态, 因为sleep或wait时收到中断自然会终止线程(以抛出异常的形式)
            while (num < 10000) {
                if (num % 100 == 0) {
                    System.out.println(num);
                }
                num++;
                // 内部trycatch的话不能停止线程
                ThreadUtils.sleepMillis(10);
            }
            System.out.println("任务完成");
        };

        Thread thread = new Thread(task);
        thread.start();
        ThreadUtils.sleepMillis(3000);
        // 通知该线程中断
        thread.interrupt();
    }
}
