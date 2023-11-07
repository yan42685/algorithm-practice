package javase.io;

import lombok.ToString;

import java.io.*;

public class ObjectSerialize {
    private final String parent = "C:/Users/419725794/OneDrive/Desktop/test2";
    private final File directory = new File(parent);
    private final File txtFile = new File(directory, "test.txt");

    public static void main(String[] args) {
        ObjectSerialize instance = new ObjectSerialize();
        instance.serialize();
    }

    private void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(txtFile));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(txtFile))
        ) {
            // 实际上是转化成Integer，而Integer继承的Number类实现了Serializable接口
            out.writeObject(new Animal());
            Object o = in.readObject();
            if (o instanceof Animal) {
                System.out.println(o);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Animal implements Serializable {
    int x = 3;
    int y = 4;
}
