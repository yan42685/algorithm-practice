package test;

public class Test2 {
    private int money;
    public static void main(String[] args) {
        PiggyBank piggyBank = new Test2().new PiggyBank();
        new Thread(piggyBank).start();
        new Thread(piggyBank).start();

    }

    private class PiggyBank implements Runnable {

        public PiggyBank() {
            money = 10000;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (money < 1000) {
                        System.out.println("余额不足");
                        return;
                    }
                    money -= 1000;
                    System.out.println(Thread.currentThread().getName() + " 取钱1000, 余额：" + money);
                }
            }
        }
    }

}


