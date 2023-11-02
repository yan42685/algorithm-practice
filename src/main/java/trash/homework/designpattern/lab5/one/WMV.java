package trash.homework.designpattern.lab5.one;

public class WMV implements VideoFileType {
    @Override
    public void decode(String platform, String filename) {
        System.out.printf("文件类型：%s, 解码平台：%s, 文件名: %s\n", "WMV", platform, filename);
    }
}
