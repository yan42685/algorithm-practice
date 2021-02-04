package temp;


import cn.hutool.core.util.RandomUtil;
import utils.Lambda;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Lambda.repeat(9,
                () -> System.out.println(RandomUtil.randomInt(10)));
        Lambda.repeat(9, Test1::test);
        try {
            TimeUnit.HOURS.sleep(1);
            TimeUnit.MINUTES.sleep(2);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AtomicInteger atomicInteger = new AtomicInteger();
    }

    private static void test() {
        System.out.println(3);
    }
}
