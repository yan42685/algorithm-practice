package concurrency.threadcoreknowledge.threadobjectmethods;

import cn.hutool.core.util.RandomUtil;
import lombok.AllArgsConstructor;
import utils.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class ConsumerProducer {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Storage {
    int maxSize;
    List<Integer> list;

    public Storage() {
        maxSize = 10;
        list = new ArrayList<>();
    }

    public synchronized void put(Integer num) {
        while (list.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(num);
        System.out.println("仓库里有了" + list.size() + "个产品");
        notify();
    }

    public synchronized void take() {
        while (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("拿到了一件, 现在仓库还剩下%d件产品\n", list.size() - 1);
        list.remove(0);
        notify();
    }
}

@AllArgsConstructor
class Producer implements Runnable {
    private final Storage storage;

    @Override
    public void run() {
        while (true) {
            storage.put(RandomUtil.randomInt());
            int interval = RandomUtil.randomInt(100, 300);
            ThreadUtils.sleepMillis(interval);
        }
    }
}

@AllArgsConstructor
class Consumer implements Runnable {
    private final Storage storage;

    @Override
    public void run() {
        while (true) {
            storage.take();
            int interval = RandomUtil.randomInt(130, 300);
            ThreadUtils.sleepMillis(interval);
        }

    }
}
