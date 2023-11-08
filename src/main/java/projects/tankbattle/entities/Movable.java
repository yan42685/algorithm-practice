package projects.tankbattle.entities;

import projects.tankbattle.constants.DirectionEnum;
import lombok.Getter;
import lombok.Setter;
import projects.tankbattle.constants.FactionEnum;

/**
 * 为了简化实现，默认所有实体都是矩形
 */
@Getter
public abstract class Movable extends Rectangle {
    protected DirectionEnum direction;
    // 步长
    protected double step;
    // 阵营
    protected FactionEnum faction;

    public Movable(double x, double y, double width, double height,
                   DirectionEnum direction, double step, FactionEnum faction) {
        super(x, y, width, height);
        this.direction = direction;
        this.step = step;
        this.faction = faction;
    }

    /**
     * 指定方向移动
     */
    public void move(DirectionEnum nextDirection) {
        Point nextPoint = nextPosition(nextDirection);
        x = nextPoint.getX();
        y = nextPoint.getY();
        direction = nextDirection;
    }

    /**
     * 下一次移动的目的坐标
     */
    private Point nextPosition(DirectionEnum nextDirection) {
        switch (nextDirection) {
            case UP:
                return new Point(x, y - getStep());
            case DOWN:
                return new Point(x, y + getStep());
            case LEFT:
                return new Point(x - getStep(), y);
            case RIGHT:
                return new Point(x + getStep(), y);
            default:
                throw new IllegalArgumentException(nextDirection.toString());
        }
    }

    /**
     * 当前占用的矩形空间
     */
    public Rectangle currentRectangle() {
        return getRectByPositionAndDirection(new Point(x, y), direction);
    }

    /**
     * 下一次移动会占用的矩形空间
     */
    public Rectangle nextRectangle(DirectionEnum nextDirection) {
        return getRectByPositionAndDirection(nextPosition(nextDirection), nextDirection);
    }

    private Rectangle getRectByPositionAndDirection(Point point, DirectionEnum direction) {
        // 当方向为LEFT，RIGHT时，需要交换width和height
        double realWidth;
        double realHeight;
        switch (direction) {
            case UP:
            case DOWN:
                realWidth = width;
                realHeight = height;
                break;
            case LEFT:
            case RIGHT:
                realWidth = height;
                realHeight = width;
                break;
            default:
                throw new IllegalArgumentException(direction.toString());
        }
        return new Rectangle(point.getX(), point.getY(), realWidth, realHeight);
    }
}
