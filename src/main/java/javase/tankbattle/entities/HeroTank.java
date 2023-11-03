package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.constants.TankType;

public class HeroTank extends AbstractTank {
    public HeroTank(double x, double y, Direction direction) {
        super(x, y, direction);
    }

    @Override
    protected void setType() {
        this.type = TankType.HERO;
    }
}
