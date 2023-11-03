package test;

import javax.swing.*;
import java.awt.*;

public class Test2 {
    public static void main(String[] args) {
        // 创建JFrame窗口
        JFrame frame = new JFrame("青色矩形");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 创建一个自定义的JPanel，并添加到窗口中
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 设置颜色为青色
                g.setColor(Color.CYAN);
                // 画一个矩形，参数分别是x坐标，y坐标，宽度，高度
                g.fillRect(0, 0, 200, 100);
            }
        };

        frame.add(panel);

        // 显示窗口
        frame.setVisible(true);
    }
}


