package trash.homework.designpattern.lab5.two;

public class ScrollbarDecorator extends Decorator {
    public ScrollbarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        System.out.print("带滚动条的");
        component.display();
    }
}
