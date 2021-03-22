package homework.designpattern.factory.simplefactory;

public class AbstractWallet {
    protected String way;

    public void pay(double money) {
        System.out.printf("支付方式：%s, 数额： %.2f", way, money);
    }
}
