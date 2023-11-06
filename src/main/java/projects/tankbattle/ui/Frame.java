package projects.tankbattle.ui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static final String APP_NAME = "Tank battle";

    public Frame() {
        this.setTitle(APP_NAME);
        // 获取用户主屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize((int) (width * 0.6), (int) (height * 0.6));
        // 居中
        setLocationRelativeTo(null);
        // 点x退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        new Thread(mainPanel).start();

        // setVisible(true) 要放在最后一行, 不然可能无法渲染出panel
        this.setVisible(true);
    }

}
