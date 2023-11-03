package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
public class Bullet extends Movable implements Runnable {
    private double speed = 1.7;
    private int radius = 10;
    // 射程
    private double range = 400.0;
    private boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y, direction);
    }

    @Override
    public void run() {

    }
}
