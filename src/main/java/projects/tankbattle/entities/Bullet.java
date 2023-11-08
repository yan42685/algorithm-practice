package projects.tankbattle.entities;

import lombok.Data;
import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.constants.FactionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class Bullet extends Movable {
    // 默认射程
    private static final double RANGE = 280.0;
    private int damage = 1;
    // 剩余可飞行路程
    private double remainingDistance = RANGE;

    public Bullet(double x, double y, DirectionEnum direction, FactionEnum faction) {
        super(x, y, 7, 7, direction, 4.5, faction);
    }
}
