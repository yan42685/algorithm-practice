package projects.tankbattle.ui;

import lombok.Getter;
import projects.tankbattle.core.GameRecorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {
    private static final String APP_NAME = "Tank battle";
    @Getter
    private MainPanel mainPanel;

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

        mainPanel = new MainPanel();
        this.add(mainPanel);

        registerListeners();

        // setVisible(true) 要放在最后一行, 不然可能无法渲染出panel
        this.setVisible(true);
    }

    private void registerListeners() {
        // 退出时保存数据
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (GameRecorder.isClosingNormally()) {
                    GameRecorder.INSTANCE.saveData();
                }
            }
        });
    }

}
