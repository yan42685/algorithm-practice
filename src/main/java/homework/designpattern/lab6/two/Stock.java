package homework.designpattern.lab6.two;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String name;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double newPrice) {
        double variationRange = (newPrice - this.price) / this.price;
        this.price = newPrice;
        if (Math.abs(variationRange) > 0.05) {
            emitMessage();
        }
    }

    @Override
    public void emitMessage() {
        observers.forEach(x -> x.update(this.name, this.price));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
