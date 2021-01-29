package concurrency.synchronized1;

/**
 * 手写死锁
 *
 * @author alexyan
 * @date 11/14/2019 14:59
 */
public class DeadLock {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println("Thread a get LOCK_A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK_B) {
                    System.out.println("Thread a is running");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (LOCK_B) {
                System.out.println("Thread b get LOCK_B");
                synchronized (LOCK_A) {
                    System.out.println("Thread B is running");
                }
            }
        }).start();


    }
}
