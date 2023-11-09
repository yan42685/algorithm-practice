package projects.tankbattle.core;

import lombok.extern.slf4j.Slf4j;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.*;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class TankUtils {
    private TankUtils() {
    }

    /**
     * 为每个线程创建不同的随机数生成器
     *
     * @return [min, max) 之间的随机int数
     */
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * 下次移动是否越界
     */
    public static boolean willBeOutOfBounds(Rectangle area, Movable movable, DirectionEnum nextDirection) {
        Rectangle r = movable.nextRectangle(nextDirection);
        return r.getX() < 0 || r.getX() + r.getWidth() > area.getWidth()
                || r.getY() < 0 || r.getY() + r.getHeight() > area.getHeight();

    }

}
