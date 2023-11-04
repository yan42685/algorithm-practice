package javase.tankbattle.utils;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.Movable;
import javase.tankbattle.entities.Point;

import javax.swing.*;

public class TankUtils {
    private TankUtils() {
    }

    /**
     * 下次移动是否在panel内
     */
    public static boolean willBeInsideBounds(JPanel panel, Movable movable, Direction nextDirection) {
        Point nextPoint = movable.getNextPoint(nextDirection);
        // 向上状态的宽与高
        int width;
        int height;
        double x = nextPoint.getX();
        double y = nextPoint.getY();
        // 根据方向确定边界
        switch (nextDirection) {
            case UP:
            case DOWN:
                width = movable.getWidth();
                height = movable.getHeight();
                break;
            case LEFT:
            case RIGHT:
                width = movable.getHeight();
                height = movable.getWidth();
                break;
            default:
                throw new IllegalArgumentException(nextDirection.toString());
        }
        return x >= 0 && x + width <= panel.getWidth() && y >= 0 && y + height <= panel.getHeight();
    }
}
