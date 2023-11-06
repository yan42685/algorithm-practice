package projects.tankbattle.commands;

import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.Movable;
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
