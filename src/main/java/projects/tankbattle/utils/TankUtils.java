package projects.tankbattle.utils;

import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.*;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class TankUtils {
    private TankUtils() {
    }

    /**
     * 为每个线程创建不同的随机数生成器
     * @return [min, max) 之间的随机int数
     */
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * 下次移动是否越界
     */
    public static boolean willBeOutOfBounds(JPanel panel, Movable movable, DirectionEnum nextDirection) {
        Rectangle r = movable.nextRectangle(nextDirection);
        return r.getX() < 0 || r.getX() + r.getWidth() > panel.getWidth()
                || r.getY() < 0 || r.getY() + r.getHeight() > panel.getHeight();
    }

}
