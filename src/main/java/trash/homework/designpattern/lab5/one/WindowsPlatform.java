package trash.homework.designpattern.lab5.one;

public class WindowsPlatform extends Platform {
    @Override
    public void play(String filename) {
        videoFileType.decode("windows", filename);
    }
}
