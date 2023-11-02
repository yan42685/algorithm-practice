package trash.homework.designpattern.lab5.two;

public class TransparentDecorator extends Decorator {
    public TransparentDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        System.out.print("透明的");
        component.display();
    }
}
