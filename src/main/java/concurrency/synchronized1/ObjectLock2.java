package concurrency.synchronized1;

import utils.ThreadUtils;

public class ObjectLock2 implements Runnable {
    public static void main(String[] args) {
        ObjectLock2 instance = new ObjectLock2();
        new Thread(instance).start();
        new Thread(instance).start();
    }


    @Override
    public void run() {
        test();
    }

    // 锁是this
    private synchronized void test() {
        System.out.println(Thread.currentThread().getName() + "我是对象锁的方法调用形式 ---- start");
        ThreadUtils.sleepSeconds(2);
        System.out.println(Thread.currentThread().getName() + "我是对象锁的方法调用形式 ---- end");
    }
}
