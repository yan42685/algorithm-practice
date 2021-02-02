package temp;


import cn.hutool.core.util.RandomUtil;
import utils.Lambda;

public class Test1 {
    public static void main(String[] args) {
        Lambda.repeat(9,
                () -> System.out.println(RandomUtil.randomInt(10)));
        Lambda.repeat(9, Test1::test);
    }

    private static void test() {
        System.out.println(3);
    }
}
