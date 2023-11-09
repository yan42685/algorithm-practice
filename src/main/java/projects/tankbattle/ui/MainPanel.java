package projects.tankbattle.ui;

import lombok.Getter;
import projects.tankbattle.entities.Rectangle;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainPanel extends JPanel {

    public Rectangle battleArea;
    public Rectangle recordArea;
    private final GameManager gameManager;

    public MainPanel() {
        // 初始化区域，避免空指针异常
        updateAreaSize();
        gameManager = new GameManager(this);
        gameManager.startGame();
    }

    @Override
    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        // 动态获取区域大小
        updateAreaSize();
        // 画背景
        PaintBrush.drawBattleArea(brush, battleArea);
        PaintBrush.drawGameRecord(brush, recordArea);
        // 画坦克
        PaintBrush.drawTanks(brush, gameManager.getTanks());
        // 画子弹
        PaintBrush.drawBullets(brush, gameManager.getBullets());
    }

    private void updateAreaSize() {
        Dimension size = getSize();
        battleArea = new Rectangle(0, 0, 0.8 * size.width, size.height);
        // 宽度之和要略大于getSize().width，因为获取的窗口大小比实际小一点
        recordArea = new Rectangle(0.8 * size.width, 0, 0.21 * size.width, size.height);
    }
}
