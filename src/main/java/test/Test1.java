package test;


import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}

class Animal {
    final String type = "test";
    int age = 1;
}

class Dog extends Animal {
    int age = 10;

    public void shout() {
        System.out.println("shout");
    }
}