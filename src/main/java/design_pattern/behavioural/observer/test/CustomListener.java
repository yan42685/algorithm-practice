package design_pattern.behavioural.observer.test;

import design_pattern.behavioural.observer.Subscribe;

public class CustomListener {
    @Subscribe
    public void sayHello(CustomEvent event) {
        System.out.printf("Trigger %s\n", event.getMessage());
        System.out.println("finished");
    }
}
