package javase.tankbattle.entities;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Getter
public abstract class AbstractTank extends Movable {
    // 重新声明一个于父类同名的属性 可能出现静态绑定问题
    protected double step = 5.0;
    protected int health = 1;
    // 最小射击间隔, 单位毫秒
    protected int minShootInterval = 500;
    // 上次射击时间
    protected long lastShootTime = 0;
    // 阵营
    protected FactionEnum faction;

    public AbstractTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction);
        // 向上状态的宽与高
        // 宽度为 10 + 20 + 10
        width = 40;
        // 高度为 60
        height = 60;
        setFaction();
    }



    public @Nullable Bullet shoot() {
        long currentTime = System.currentTimeMillis();
        // 限制射击频率
        if (currentTime - lastShootTime < minShootInterval) {
//            return null;
        }

        lastShootTime = currentTime;
        Point shootPoint = getShootPoint();
        Bullet bullet = new Bullet(shootPoint.getX(), shootPoint.getY(), direction, faction);
        new Thread(bullet).start();

        return bullet;
    }


    // 射击起点
    private Point getShootPoint() {
        switch (direction) {
            case UP:
                return new Point(x + 20, y);
            case DOWN:
                return new Point(x + 20, y + 60);
            case LEFT:
                return new Point(x, y + 20);
            case RIGHT:
                return new Point(x + 60, y + 20);
            default:
                throw new IllegalArgumentException(direction.toString());
        }
    }

    protected abstract void setFaction();

}
