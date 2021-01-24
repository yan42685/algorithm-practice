package design_pattern.behavioural.observer.test;

import design_pattern.behavioural.observer.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        CustomListener listener = new CustomListener();
        eventBus.register(listener);
        eventBus.emit(new CustomEvent("hello111111"));
    }
}
