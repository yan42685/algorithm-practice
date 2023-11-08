package projects.tankbattle.ui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainPanel extends JPanel {

    private final GameManager gameManager;

    public MainPanel() {
        gameManager = new GameManager(this);
        gameManager.startGame();
    }

    @Override
    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        // 画背景
        PaintBrush.drawBackground(brush, getSize());
        // 画坦克
        PaintBrush.drawTanks(brush, gameManager.getTanks());
        // 画子弹
        PaintBrush.drawBullets(brush, gameManager.getBullets());
    }
}
