package trash.homework.designpattern.lab5.one;

public class UnixPlatform extends Platform {
    @Override
    public void play(String filename) {
        videoFileType.decode("unix", filename);
    }
}
