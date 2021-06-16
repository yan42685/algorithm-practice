package homework.designpattern.lab6.one;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpecificBusinessProxy implements Business {
    private final SpecificBusiness specificBusiness = new SpecificBusiness();

    @Override
    public void doSomething() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String currentDateTime = formatter.format(LocalDateTime.now());
        System.out.printf("---- 方法被调用 当前时间: %s ----\n", currentDateTime);
        try {
            specificBusiness.doSomething();
            System.out.println("方法调用成功");
        } catch (Exception e) {
            System.out.println("方法调用失败");
        }

    }
}
