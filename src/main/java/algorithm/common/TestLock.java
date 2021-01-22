package algorithm.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alexyan
 * @date 11/14/2019 19:55
 */
public class TestLock {
    boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    public void test1() throws InterruptedException {
        try {
            lock.lock();
            condition1.await();
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void test2() throws InterruptedException {
        try {
            lock.lock();
            condition2.await();
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

}
