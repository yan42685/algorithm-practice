package homework.shixun.day01;

public class T2 {
    public static void main(String[] args) {
        double newPhonePrice = 7988;
        // 不以旧换新的花费
        double cost1 = newPhonePrice - 1500;
        // 以旧换新的花费
        double cost2 = newPhonePrice * 0.8;
        if (cost1 > cost2) {
            System.out.println("以旧换新更省钱");
        } else if (cost1 < cost2) {
            System.out.println("不以旧换新更省钱");
        } else {
            System.out.println("两种方案花费相同");
        }
    }
}
