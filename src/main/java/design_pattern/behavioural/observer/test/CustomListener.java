package design_pattern.behavioural.observer.test;

import design_pattern.behavioural.observer.Subscribe;

public class CustomListener {
    @Subscribe
    // private 方法也可以调用
    private void callback(CustomEvent event) {
        System.out.printf("Trigger %s\n", event.getMessage());
    }
}
