package concurrency.synchronized1;

import utils.ThreadUtils;

public class ClassLock1 implements Runnable {
    public static void main(String[] args) {
        ClassLock1 instance1 = new ClassLock1();
        ClassLock1 instance2 = new ClassLock1();

        // 即使传了不同的Runnable, 也是串行运行的
        new Thread(instance1).start();
        new Thread(instance2).start();
    }

    @Override
    public void run() {
        test();
    }

    private synchronized static void test() {
        System.out.println(Thread.currentThread().getName() + "  classLock开始");
        ThreadUtils.sleepSeconds(2);
        System.out.println(Thread.currentThread().getName() + "  classLock结束");
    }
}
