package homework.designpattern.lab5.one;

public class RMVB implements VideoFileType {
    @Override
    public void decode(String platform, String filename) {
        System.out.printf("文件类型：%s, 解码平台：%s, 文件名: %s\n", "RMVB", platform, filename);
    }
}
