package utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
    public static long toMillis(long period, TimeUnit timeUnit) {
        switch (timeUnit) {
            case HOURS:
                return period * 3600000;
            case MINUTES:
                return period * 60000;
            case SECONDS:
                return period * 1000;
            case MILLISECONDS:
                return period;
            default:
                throw new RuntimeException("不支持该时间单位: " + timeUnit);
        }
    }

    public static void measureExecuteTime(int times, Runnable function) {
        long startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            function.run();
        }
        long endTime = System.nanoTime();
        System.out.printf("运行次数：%d 运行时间: %d纳秒\n", times, endTime - startTime);
    }
}
