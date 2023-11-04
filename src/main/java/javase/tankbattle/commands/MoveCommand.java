package javase.tankbattle.commands;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.Movable;
import lombok.Getter;

@Getter
public class MoveCommand implements Command {
    private final Movable movable;
    private final Direction nextDirection;

    public MoveCommand(Movable movable, Direction nextDirection) {
        this.movable = movable;
        this.nextDirection = nextDirection;
    }

    @Override
    public boolean execute() {
        movable.move(nextDirection);
        return true;
    }
}
