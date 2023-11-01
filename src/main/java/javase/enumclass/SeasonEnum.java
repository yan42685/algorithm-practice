package javase.enumclass;

// enum关键字就是饿汉单例模式的语法糖
public enum SeasonEnum {
    // 编译后变成public static final SeasonEnum SPRING = new SeasonEnum("春");
    SPRING("春"),SUMMER("夏"), AUTUMN("秋"), WINTER("冬");
    // 覆盖了无参构造器
    SeasonEnum(String chineseName) {
        this.chineseName = chineseName;
    }
    String chineseName;
}
