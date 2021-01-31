package concurrency.threadcoreknowledge.createthread;

public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用继承 Thread 实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}

