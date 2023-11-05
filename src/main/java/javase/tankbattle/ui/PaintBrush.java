package javase.tankbattle.ui;

import javase.tankbattle.constants.FactionEnum;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Bullet;

import java.awt.*;
import java.util.Collection;

/**
 * 绘制各种图形的画笔
 */
public class PaintBrush {

    // 阻止被实例化
    private PaintBrush() {
    }

    public static void drawBackground(Graphics brush, Dimension panelSize) {
        brush.setColor(Color.DARK_GRAY);
        brush.fillRect(0, 0, panelSize.width, panelSize.height);
    }

    public static void drawTanks(Graphics brush, Collection<AbstractTank> tanks) {
        tanks.forEach(tank -> {
            if (!tank.isAlive()) {
                return;
            }
            FactionEnum faction = tank.getFaction();
            if (faction.equals(FactionEnum.HERO)) {
                brush.setColor(Color.CYAN);
            } else if (faction.equals(FactionEnum.ENEMY)) {
                brush.setColor(Color.ORANGE);
            } else {
                throw new IllegalArgumentException(faction.toString());
            }
            int x = (int) tank.getX();
            int y = (int) tank.getY();
            switch (tank.getDirection()) {
                case UP:
                    brush.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                    brush.fill3DRect(x + 30, y, 10, 60, false);  // 右边轮子
                    brush.fill3DRect(x + 10, y + 10, 20, 40, false);  // 中间矩形
                    brush.fillOval(x + 10, y + 20, 20, 20);  // 中间圆形
                    brush.drawLine(x + 20, y + 30, x + 20, y);  // 炮管
                    break;
                case DOWN:
                    brush.fill3DRect(x, y, 10, 60, false);
                    brush.fill3DRect(x + 30, y, 10, 60, false);
                    brush.fill3DRect(x + 10, y + 10, 20, 40, false);
                    brush.fillOval(x + 10, y + 20, 20, 20);
                    brush.drawLine(x + 20, y + 30, x + 20, y + 60);
                    break;
                case LEFT:
                    brush.fill3DRect(x, y, 60, 10, false);
                    brush.fill3DRect(x, y + 30, 60, 10, false);
                    brush.fill3DRect(x + 10, y + 10, 40, 20, false);
                    brush.fillOval(x + 20, y + 10, 20, 20);
                    brush.drawLine(x + 30, y + 20, x, y + 20);
                    break;
                case RIGHT:
                    brush.fill3DRect(x, y, 60, 10, false);
                    brush.fill3DRect(x, y + 30, 60, 10, false);
                    brush.fill3DRect(x + 10, y + 10, 40, 20, false);
                    brush.fillOval(x + 20, y + 10, 20, 20);
                    brush.drawLine(x + 30, y + 20, x + 60, y + 20);
                    break;
                default:
                    throw new IllegalArgumentException(tank.getDirection().toString());
            }
        });
    }

    public static void drawBullets(Graphics brush, Collection<Bullet> bullets) {
        brush.setColor(Color.ORANGE);
        bullets.stream().filter(Bullet::isAlive).forEach(
                bullet -> {
                    int radius = bullet.getWidth() / 2;
                    int x = (int) bullet.getX();
                    int y = (int) bullet.getY();
                    brush.fillOval(x - radius, y - radius, radius * 2, radius * 2);
                }
        );

    }
}
