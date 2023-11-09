package projects.tankbattle.core;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.entities.Bullet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 记录游戏运行信息
 */
@Slf4j
public enum GameRecorder {
    INSTANCE;

    // 根目录 + 相对路径
    private static final String TARGET_FILE_PATH = System.getProperty("user.dir").replace("\\", "/")
            + "/src/main/java/projects/tankbattle/resources/tankbattle_data.txt";
    private static final File TARGET_FILE = new File(TARGET_FILE_PATH);
    // 如果非正常关闭则不保存存档
    @Getter
    private static boolean isClosingNormally = true;

    private GameManager gameManager;
    /**
     * 死亡的敌人坦克数量
     */
    @Getter
    private int deadEnemiesCount = 0;

    public void setContext(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    public void increaseDeadEnemiesCount(int num) {
        deadEnemiesCount += num;
    }

    /**
     * 数据存档
     */
    @SneakyThrows
    public void saveData() {
        if (!TARGET_FILE.exists()) {
            TARGET_FILE.createNewFile();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get(TARGET_FILE_PATH))))) {
            // 死亡敌人坦克数
            out.writeInt(deadEnemiesCount);
            out.writeObject(gameManager.getBullets());
            out.writeObject(gameManager.getBulletQueue());
            out.writeObject(gameManager.getTanks());
        }
    }

    /**
     * 读取存档
     */
    public void recoverData() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(Paths.get(TARGET_FILE_PATH))))) {
            if (!TARGET_FILE.exists()) {
                throw new FileNotFoundException();
            }
            int deadEnemiesCount = in.readInt();
            List<Bullet> bullets = (List<Bullet>) in.readObject();
            BlockingQueue<Bullet> bulletQueue = (BlockingQueue<Bullet>) in.readObject();
            List<AbstractTank> tanks = (List<AbstractTank>) in.readObject();
            String information = String.format("存档读取成功! 场上子弹数: %d, 敌方坦克数%d", bullets.size(), tanks.size() - 1 - deadEnemiesCount);
            log.info(information);

            this.deadEnemiesCount = deadEnemiesCount;
            gameManager.setBullets(bullets);
            gameManager.setBulletQueue(bulletQueue);
            gameManager.setTanks(tanks);
        } catch (FileNotFoundException e) {
            isClosingNormally = false;
            log.error("存档文件不存在，读取失败");
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            isClosingNormally = false;
            log.error("存档文件已损坏，读取失败。");
            log.info("正在删除损坏存档...");
            if (TARGET_FILE.delete()) {
                log.info("已删除损坏存档");
            } else {
                log.error("删除损坏存档失败，请手动删除，存档位置为" + TARGET_FILE_PATH);
            }
        }
    }

    public boolean hasSavedData() {
        return TARGET_FILE.exists();
    }
}
