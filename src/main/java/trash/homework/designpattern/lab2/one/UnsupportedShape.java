package trash.homework.designpattern.lab2.one;

public class UnsupportedShape implements Shape {
    @Override
    public void draw() {
        throw new UnsupportedShapeException();
    }

    @Override
    public void erase() {
        System.out.println("不能擦除不支持的形状");
    }
}
