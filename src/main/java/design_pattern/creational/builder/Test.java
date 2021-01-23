package design_pattern.creational.builder;


public class Test {
    public static void main(String[] args) {
        Phone phone = Phone.builder()
                .name("hah")
                .length(3)
                .width(5)
                .build();
        phone.printInfo();
    }
}
