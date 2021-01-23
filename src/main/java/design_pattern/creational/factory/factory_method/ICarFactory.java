package design_pattern.creational.factory.factory_method;

/**
 * 注意这里和简单工厂不一样，create用的是非静态方法，因为静态方法无法重写
 */
public interface ICarFactory {
    ICar createCar();
}

class ACarFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new ACar();
    }
}

class BCarFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new BCar();
    }
}
