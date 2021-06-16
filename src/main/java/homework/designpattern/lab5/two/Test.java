package homework.designpattern.lab5.two;

public class Test {
    public static void main(String[] args) {
        Component window = new TransparentDecorator(new Window());
        window.display();
    }
}
