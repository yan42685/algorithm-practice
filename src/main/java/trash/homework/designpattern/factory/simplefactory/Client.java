package trash.homework.designpattern.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        AbstractWallet wallet = WalletFactory.create("zhifubao");
        wallet.pay(30.32);
    }
}
