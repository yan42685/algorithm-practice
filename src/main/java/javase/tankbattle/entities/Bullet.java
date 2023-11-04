package javase.tankbattle.entities;

import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.Direction;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Accessors(chain = true)
@Getter
public class Bullet extends Movable implements Runnable {
    // 射程
    private static final double RANGE = 280.0;
    // 剩余可飞行路程
    private double remainingDistance = RANGE;

    public Bullet(double x, double y, Direction direction) {
        super(x, y, direction);
        step = 3.0;
        width = 7;
        height = 7;
    }

    @Override
    public void run() {
        while (isAlive) {
            if (remainingDistance >= step) {
                try {
                    Thread.sleep(Constants.REPAINT_INTERVAL);
                    move(direction);
                    remainingDistance -= step;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                isAlive = false;
                break;
            }
        }
    }
}
