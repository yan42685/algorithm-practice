package algorithm.basic.sort.test;


import algorithm.basic.sort.SortAlgorithm;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import lombok.SneakyThrows;

import java.util.Set;

public class TestSortAlgorithm {
    private static final int[] NUMS = {3, 2, 1, 5, 6, 4};
    private static final int[] SORTED = {1, 2, 3, 4, 5, 6};
    private static final String PACKAGE = "algorithm.common.sort";

    public static void main(String[] args) {
        testAllClasses();
    }

    @SneakyThrows
    private static void testAllClasses() {
        Set<Class<?>> classes = ClassUtil.scanPackageBySuper(PACKAGE, SortAlgorithm.class);
        for (Class<?> clazz : classes) {
            testOneClass((SortAlgorithm) clazz.newInstance());
        }
    }

    private static void testOneClass(SortAlgorithm algorithm) {
        int[] cloned = ArrayUtil.clone(NUMS);
//         Assert.isTrue(cloned != ARRAY);
        algorithm.sort(cloned);
        Assert.isTrue(ArrayUtil.equals(cloned, SORTED));
        System.out.printf("%s 通过测试\n", algorithm.getClass().getName());
    }
}
