package javase.tankbattle.entities;

import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
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
    // 由哪种类型的坦克发射
    private FactionEnum faction;

    public Bullet(double x, double y, DirectionEnum direction, FactionEnum faction) {
        super(x, y, direction);
        step = 3.0;
        width = 7;
        height = 7;
        this.faction = faction;
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
