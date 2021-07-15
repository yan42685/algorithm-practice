package homework.shixun.day03;

class Phone {
    private String brand;

    private double price;

    public Phone() {
    }

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public void call() {
        System.out.printf("正在使用价格为%.0f元的%s品牌的手机打电话\n", price, brand);
    }

    public void sendMessage() {
        System.out.printf("正在使用价格为%.0f元的%s品牌的手机发短信\n", price, brand);
    }

    public void playGame() {
        System.out.printf("正在使用价格为%.0f元的%s品牌的手机玩游戏\n", price, brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

public class T1 {
    public static void main(String[] args) {
        Phone phone1 = new Phone("小米", 998);
        phone1.call();
        phone1.sendMessage();
        phone1.playGame();

        System.out.println();
        Phone phone2 = new Phone();
        phone2.setBrand("小米");
        phone2.setPrice(998);
        phone2.call();
        phone2.sendMessage();
        phone2.playGame();
    }
}

