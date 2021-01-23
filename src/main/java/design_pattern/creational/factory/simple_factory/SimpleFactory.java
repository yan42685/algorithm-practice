package design_pattern.creational.factory.simple_factory;

/**
 * 简单方法的思想是将对象的创建逻辑与行为逻辑分离
 */
public class SimpleFactory {

    public static IProduct create(ProductType type) {
        switch (type) {
            case TYPE_A:
                return new ProductA();
            case TYPE_B:
                return new ProductB();
            default:
                // 因为找不到产品肯定是代码出错了，需要及时 fail 而不是返回 null
                throw new RuntimeException("产品不存在, type = " + type.toString());
        }

    }
}
