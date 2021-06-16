package homework.designpattern.lab6.two;

public class Investor implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.printf("%s 价格变化幅度大于5%%，现价为：%.2f\n", stockName, price);
    }
}
