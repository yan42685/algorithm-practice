package design_pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋盘
 */
public class ChessBoard {
    private final Map<Integer, ChessPiece> chessPieceMap = new HashMap<>();

    public ChessBoard() {
        init();
    }

    public void display() {
        chessPieceMap.forEach((k, v) -> {
            System.out.println(k + ".");
            System.out.println("name: " + v.getUnit().getName());
            System.out.println("color: " + v.getUnit().getColor());
            System.out.printf("position: x = %d   y = %d\n", v.getPositionX(), v.getPositionY());
        });
    }

    private void init() {
        chessPieceMap.put(1, new ChessPiece(ChessPieceUnitFactory.get(1), 0, 0));
        chessPieceMap.put(2, new ChessPiece(ChessPieceUnitFactory.get(2), 0, 1));
    }

}
