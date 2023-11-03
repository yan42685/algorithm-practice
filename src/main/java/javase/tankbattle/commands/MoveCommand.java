package javase.tankbattle.commands;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Movable;

public class MoveCommand implements Command {
    private final Movable movable;
    private final Direction direction;

    public MoveCommand(Movable movable, Direction direction) {
        this.movable = movable;
        this.direction = direction;
    }

    @Override
    public boolean execute() {
        movable.move(direction);
        return true;
    }
}
