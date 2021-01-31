package concurrency.threadcoreknowledge.createthread;

public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("用 Runnable 实现线程");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }
}
