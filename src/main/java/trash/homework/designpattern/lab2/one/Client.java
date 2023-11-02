package trash.homework.designpattern.lab2.one;

public class Client {
    public static void main(String[] args) {
        Shape triangle = ShapeFactory.create("triangle");
        triangle.draw();
        triangle.erase();
        Shape unknown = ShapeFactory.create("123");
        unknown.draw();
    }
}
