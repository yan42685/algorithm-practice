package projects.tankbattle.utils;

import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.*;

import javax.swing.*;

public class TankUtils {
    private TankUtils() {
    }

    /**
     * @return [min, max] 之间的随机int数
     */
    public static int randomInt(int min, int max) {
        return min + Constants.RANDOM.nextInt(max - min + 1);
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
