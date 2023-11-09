package projects.tankbattle.core;

import lombok.Getter;
import lombok.Setter;
import projects.tankbattle.constants.FactionEnum;

import java.io.File;
import java.io.IOException;

/**
 * 记录游戏运行信息
 */
public enum GameRecorder {
    INSTANCE;
    // 根目录 + 相对路径
    private static final String TARGET_DIR = System.getProperty("user.dir").replace("\\", "/")
            + "/src/main/java/projects/tankbattle/resources/";

    private GameManager gameManager;
    /**
     * 死亡的敌人坦克数量
     */
    @Getter
    private int deadEnemiesCount = 0;
    public void setContext(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(TARGET_DIR);
        File file = new File(TARGET_DIR + "111.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        file.createNewFile();
//        "C:\Users\419725794\OneDrive\Desktop\Alex\mycode\java-practice\src\main\java\projects\tankbattle\resources"

    }
    public void increaseDeadEnemiesCount(int num) {
        deadEnemiesCount += num;
    }

}
