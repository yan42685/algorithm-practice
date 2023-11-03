package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.constants.TankType;

public class EnemyTank extends AbstractTank {
    public EnemyTank(double x, double y, Direction direction) {
        super(x, y, direction);
    }

    @Override
    protected void setType() {
        this.type = TankType.ENEMY;
    }
}
