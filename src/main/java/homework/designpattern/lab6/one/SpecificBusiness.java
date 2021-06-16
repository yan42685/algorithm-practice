package homework.designpattern.lab6.one;

public class SpecificBusiness implements Business {
    @Override
    public void doSomething() {
        throw new RuntimeException();
    }
}
