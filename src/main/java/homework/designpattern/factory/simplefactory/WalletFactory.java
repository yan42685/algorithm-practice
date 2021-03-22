package homework.designpattern.factory.simplefactory;

public class WalletFactory {
    public static AbstractWallet create(String type) {
        switch (type) {
            case "cash":
                return new Cash();
            case "creditCard":
                return new CreditCard();
            case "weixin":
                return new WeiXin();
            case "zhifubao":
                return new ZhiFuBao();
            default:
                throw new RuntimeException("未知的支付类型!");
        }
    }
}
