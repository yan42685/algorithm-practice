package projects.tankbattle.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor {
    private ThreadExecutor() {}
    private static class Holder {
        private static ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10, 50, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void submit(Runnable task) {
        Holder.pool.submit(task);
    }
}
