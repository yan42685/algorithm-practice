package trash.homework.designpattern.lab5.one;

public class Test {
    public static void main(String[] args) {
        Platform windowsPlatform = new WindowsPlatform();
        windowsPlatform.setVideoFileType(new WMV());
        windowsPlatform.play("testFile");
    }
}
