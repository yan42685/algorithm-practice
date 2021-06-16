package homework.designpattern.lab6.two;

public class Test {
    public static void main(String[] args) {
        Stock maotai = new Stock("贵州茅台", 2100);
        Investor investorA = new Investor();
        maotai.addObserver(investorA);
        maotai.setPrice(2300);
        maotai.setPrice(2301);
        maotai.setPrice(2420);
    }
}
