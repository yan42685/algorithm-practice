package javase.tankbattle.ui;

import javase.tankbattle.constants.TankType;
import javase.tankbattle.entities.AbstractTank;

import java.awt.*;

// 绘制各种图形的画笔
public class PaintBrush {
    public static void drawBackground(Graphics g, Dimension panelSize) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, panelSize.width, panelSize.height);
    }

    public static void drawTank(Graphics g, AbstractTank tank) {
        TankType type = tank.getType();
        if (type.equals(TankType.HERO)) {
            g.setColor(Color.CYAN);
        } else if (type.equals(TankType.ENEMY)) {
            g.setColor(Color.ORANGE);
        }
        int x = (int) tank.getX();
        int y = (int) tank.getY();
        switch (tank.getDirection()) {
            case UP:
                g.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  // 右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case DOWN:
            default:
                throw new IllegalArgumentException("Illegal direction: " + tank.getDirection());
        }
    }
}
