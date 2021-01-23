package design_pattern.structural.flyweight;

import lombok.Getter;

/**
 * 共享的单元
 * <p>
 * 封装不变的共享的状态
 * 即名字和颜色相同的棋子单元
 * </p>
 */
@Getter
public class ChessPieceUnit {
    private String name;
    private Color color;

    public ChessPieceUnit(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public enum Color {
        // 红色
        RED,
        // 黑色
        BLACK
    }
}
