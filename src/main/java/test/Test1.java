package test;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        Movable tank = new Tank(1,2);
        tank.move();
        System.out.println(tank.getX());
    }

}

class Animal {
    final String type = "test";
    int age = 1;
    protected String name = "3";
}

class Dog extends Animal {
    int age = 10;

    public synchronized void shout() {
        System.out.println("shout");

    }
}

@AllArgsConstructor
@Getter
class Movable {
    private int x;
    private int y;
    public void move () {
        System.out.println("origin x: " + x);
        --x;
        System.out.println("current x: " + x);
    }
}

class Tank extends Movable {
    public Tank(int x, int y) {
        super(x, y);
    }
}
