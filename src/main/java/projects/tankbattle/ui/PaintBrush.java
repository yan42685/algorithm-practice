package projects.tankbattle.ui;

import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.constants.FactionEnum;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.entities.Bullet;
import projects.tankbattle.entities.EnemyTank;
import projects.tankbattle.entities.Rectangle;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 绘制各种图形的画笔
 */
public class PaintBrush {

    // 阻止被实例化
    private PaintBrush() {
    }

    public static void drawBattleArea(Graphics brush, Rectangle area) {
        brush.setColor(Color.DARK_GRAY);
        brush.fillRect((int) area.getX(), (int) area.getY(), (int) area.getWidth(), (int) area.getHeight());
    }

    public static void drawGameRecord(Graphics brush, Rectangle area) {
        brush.setColor(Color.GRAY);
        int x = (int) area.getX();
        int y = (int) area.getY();
        int width = (int) area.getWidth();
        int height = (int) area.getHeight();
        brush.fillRect(x, y, width, height);

        brush.setColor(Color.BLACK);
        brush.setFont(Constants.FONT_BOLD_18);
        brush.drawString("累计击毁敌方坦克", x + (int) (0.1 * width), y + (int) (0.1 * height));
        // 绘制坦克图标
        LinkedList<AbstractTank> list = new LinkedList<>();
        list.add(new EnemyTank(x + (int) (0.1 * width), y + (int) (0.17 * height), DirectionEnum.UP));
        drawTanks(brush, list);
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
                    int radius = (int) bullet.getWidth() / 2;
                    int x = (int) bullet.getX();
                    int y = (int) bullet.getY();
                    brush.fillOval(x - radius, y - radius, radius * 2, radius * 2);
                }
        );

    }
}
