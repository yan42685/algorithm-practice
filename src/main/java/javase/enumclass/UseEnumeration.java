package javase.enumclass;

public class UseEnumeration {
    public static void main(String[] args) {
        SeasonEnum spring = SeasonEnum.SPRING;
        System.out.println(spring.name());  // 常量名
        System.out.println(spring.chineseName);  // 属性
        System.out.println(spring.ordinal());  // 编号
        for (SeasonEnum season : SeasonEnum.values()) {
            System.out.print(season + "\t");
        }
        System.out.println();
//        System.out.println(SeasonEnum.valueOf());
//        Enum



    }
}
