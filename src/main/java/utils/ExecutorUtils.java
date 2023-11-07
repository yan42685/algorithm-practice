package utils;

import java.util.concurrent.*;

/**
 * 参考线程池最佳实践：https://github.com/langyastudio/langya-doc/blob/master/docs/java/concurrent/%E7%BA%BF%E7%A8%8B%E6%B1%A0%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5.md
 */
public class ExecutorUtils {

    private ExecutorUtils() {
    }

    /**
     * 需要自定义参数是因为JDK的默认实现有各种缺点
     * FixedThreadPool 和 SingleThreadExecutor ：允许请求的队列长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致 OOM。
     * CachedThreadPool 和 ScheduledThreadPool ：允许创建的线程数量为 Integer.MAX_VALUE ，可能会创建大量线程，从而导致 OOM。
     */

    public static ThreadPoolExecutor createDefaultPool() {
        return new ThreadPoolExecutor(
                10,
                30,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
