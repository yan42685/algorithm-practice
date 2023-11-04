package javase.tankbattle.utils;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Bullet;
import javase.tankbattle.entities.Movable;
import javase.tankbattle.entities.Point;

import javax.swing.*;

public class TankUtils {
    private TankUtils() {
    }

    /**
     * 下次移动是否在panel内
     */
    public static boolean willBeInsideBounds(JPanel panel, Movable movable, DirectionEnum nextDirection) {
        Point nextPoint = movable.getNextPoint(nextDirection);
        // 根据方向获取长宽
        int width = (int) realWidth(movable.getWidth(), movable.getHeight(), nextDirection);
        int height = (int) realHeight(movable.getWidth(), movable.getHeight(), nextDirection);
        double x = nextPoint.getX();
        double y = nextPoint.getY();
        return x >= 0 && x + width <= panel.getWidth() && y >= 0 && y + height <= panel.getHeight();
    }


    /**
     * 子弹是否击中坦克
     */
    public static boolean doBulletIntersectTank(Bullet bullet, AbstractTank tank) {
        double leftA = bullet.getX();
        double rightA = bullet.getX() + bullet.getWidth();
        double topA = bullet.getY();
        double bottomA = bullet.getY() + bullet.getHeight();
        double leftB = tank.getX();
        double rightB = tank.getX() + realWidth(tank.getWidth(), tank.getHeight(), tank.getDirection());
        double topB = tank.getY();
        double bottomB = tank.getY() + realHeight(tank.getWidth(), tank.getHeight(), tank.getDirection());
        return doRectanglesIntersect(leftA, rightA, topA, bottomA, leftB, rightB, topB, bottomB);
    }

    /**
     * 矩形在panel中的实际width取决于方向
     */
    private static double realWidth(double width, double height, DirectionEnum direction) {
        switch (direction) {
            case UP:
            case DOWN:
                return width;
            case LEFT:
            case RIGHT:
                return height;
            default:
                throw new IllegalArgumentException(direction.toString());
        }
    }

    /**
     * 矩形在panel中的实际height取决于方向
     */
    private static double realHeight(double width, double height, DirectionEnum direction) {
        switch (direction) {
            case UP:
            case DOWN:
                return height;
            case LEFT:
            case RIGHT:
                return width;
            default:
                throw new IllegalArgumentException(direction.toString());
        }
    }

    /**
     * 矩形相交检测
     */
    private static boolean doRectanglesIntersect(double leftA, double rightA, double topA, double bottomA,
                                                 double leftB, double rightB, double topB, double bottomB) {
        // 排除四种相离情况就能确定相交
        return !(rightA < leftB || leftA > rightB || bottomA < topB || topA > bottomB);
    }
}
