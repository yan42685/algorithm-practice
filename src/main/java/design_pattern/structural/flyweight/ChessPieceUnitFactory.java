package design_pattern.structural.flyweight;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceUnitFactory {
    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit("帅", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit("士", ChessPieceUnit.Color.BLACK));
        // ...其他共享的棋子单元
    }

    public static ChessPieceUnit get(int id) {
        AssertUtils.isTrue(pieces.containsKey(id));
        return pieces.get(id);
    }
}
