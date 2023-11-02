package trash.homework.designpattern.lab5.two;

public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
