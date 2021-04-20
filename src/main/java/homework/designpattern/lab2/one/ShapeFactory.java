package homework.designpattern.lab2.one;

public class ShapeFactory {
    public static Shape create(String type) {
        switch (type) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                return new UnsupportedShape();
        }
    }

}
