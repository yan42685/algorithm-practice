package javase.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderTest {
    private String parent = "C:/Users/419725794/OneDrive/Desktop/test2";
    private File directory = new File(parent);
    private File txtFile = new File(directory, "test.txt");

    public static void main(String[] args) {
        InputStreamReaderTest instance = new InputStreamReaderTest();

    }

    private void readByCharset(String charset) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(txtFile), StandardCharsets.UTF_8)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
