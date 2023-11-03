package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
public class Bullet extends Movable implements Runnable {
    // 射程
    private static final double RANGE = 300.0;
    private double speed = 8.0;
    private int radius = 10;
    // 剩余可飞行路程
    private double remainingDistance = RANGE;
    @Setter
    private boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y, direction);
    }

    @Override
    public void run() {

    }
}
