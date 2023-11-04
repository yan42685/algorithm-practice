package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.event.HierarchyBoundsAdapter;

@Accessors(chain = true)
@Getter
public class Bullet extends Movable implements Runnable {
    // 射程
    private static final double RANGE = 300.0;
    // 剩余可飞行路程
    private double remainingDistance = RANGE;

    public Bullet(double x, double y, Direction direction) {
        super(x, y, direction);
        speed = 8.0;
        width = 7;
        height = 7;
    }

    @Override
    public void run() {

    }
}
