package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Bullet implements Runnable{
    private double x;
    private double y;
    private Direction direction;
    private double speed = 1.7;
    private double radius = 4.0;
    // 射程
    private double range = 400.0;
    private boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {

    }
}
