package javase.tankbattle.commands;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.entities.Movable;
import lombok.Getter;

@Getter
public class MoveCommand implements Command {
    private final Movable movable;
    private final DirectionEnum nextDirection;

    public MoveCommand(Movable movable, DirectionEnum nextDirection) {
        this.movable = movable;
        this.nextDirection = nextDirection;
    }

    @Override
    public boolean execute() {
        if (!movable.isAlive()) {
            return false;
        }
        movable.move(nextDirection);
        return true;
    }
}
