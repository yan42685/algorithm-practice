package projects.tankbattle;

import projects.tankbattle.core.GameManager;
import projects.tankbattle.ui.Frame;

public class Application {
    public static void main(String[] args) {
        new GameManager().startGame();
    }
}
