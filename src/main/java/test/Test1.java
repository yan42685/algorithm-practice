package test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Test1 {

    public static void main(String[] args) {
        new LinkedBlockingQueue<>();
    }

}

@Data
abstract class Movable {
    protected double x;
    protected double y;
    protected double speed;

    public Movable(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        System.out.println("[static binding] speed = " + speed);
        System.out.println("[dynamic binding] speed = " + getSpeed());
        y -= speed;  // y -= 0.0
        y -= getSpeed();  // y -= 5.0
        setY(getY() - getSpeed());  // y -= 5.0
        System.out.println(getY());
    }
}

@Getter
class Bullet extends Movable {
    protected double speed = 5.0;

    public Bullet(double x, double y) {
        super(x, y);
    }
}