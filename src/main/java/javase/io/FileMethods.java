package javase.io;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.file.Files;

public class FileMethods {
    private static final String ABC = "3";

    private String parent = "C:/Users/419725794/OneDrive/Desktop/test2";
    private File directory = new File(parent);
    private File txtFile = new File(directory, "test.txt");

    public static void main(String[] args) {
        FileMethods instance = new FileMethods();
        instance.bufferedReader();
    }

    private void copyFile(String src, String dest) {
        // Java7提供 try-with-resource 自动关闭流
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = in.read(buffer)) != -1) {
                out.write(buffer, 0, readLength);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 一次读1个字节
    private void inputStreamRead1() {
        FileInputStream fileInputStream = null;
        int readData;
        try {
            fileInputStream = new FileInputStream(txtFile);
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 一次读一组字节
    private void inputStreamRead2() {
        FileInputStream fileInputStream = null;
        // 如果数组长度小于字符串，则遇到 > 1 字节的编码可能会出现乱码；读字符正常做法是用Reader而不是InputStream
        byte[] buffer = new byte[5];
        int readLength;
        try {
            fileInputStream = new FileInputStream(txtFile);
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, readLength));
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 写入字节
    private void outputStreamWrite() {
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = new FileOutputStream(txtFile, true);
            fileOutputStream = new FileOutputStream(txtFile);
            fileOutputStream.write("哈哈".getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void bufferedReader() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
