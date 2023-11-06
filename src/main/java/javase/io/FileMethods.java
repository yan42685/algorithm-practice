package javase.io;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class FileMethods {

    public static void main(String[] args) {
        String parent = "C:/Users/419725794/OneDrive/Desktop/";
        File file = new File(parent, "a.txt");
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
