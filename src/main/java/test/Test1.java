package test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        Movable bullet = new Bullet(10, 10);
        bullet.moveUp();
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