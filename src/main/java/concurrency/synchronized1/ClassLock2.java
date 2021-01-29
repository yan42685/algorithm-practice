package concurrency.synchronized1;

import utils.ThreadUtils;

public class ClassLock2 implements Runnable {
    public static void main(String[] args) {
        ClassLock2 instance1 = new ClassLock2();
        ClassLock2 instance2 = new ClassLock2();
        new Thread(instance1).start();
        new Thread(instance2).start();
    }


    @Override
    public void run() {
        test();
    }

    private void test() {
        synchronized (ClassLock2.class) {
            System.out.println(Thread.currentThread().getName() + "  classLock开始");
            ThreadUtils.sleepSeconds(2);
            System.out.println(Thread.currentThread().getName() + "  classLock结束");
        }
    }
}
