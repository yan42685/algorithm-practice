package design_pattern.structural.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * 棋子
 */
@Getter
public class ChessPiece {
    private final ChessPieceUnit unit;

    @Setter
    private int positionX;
    @Setter
    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.unit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
