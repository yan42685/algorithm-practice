package homework.designpattern.lab5.one;

public class LinuxPlatform extends Platform {
    @Override
    public void play(String filename) {
        videoFileType.decode("linux", filename);
    }
}
