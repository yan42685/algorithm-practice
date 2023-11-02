package test;


import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(Float.MAX_VALUE);
    }

}

class Animal {
    final String type = "test";
    int age = 1;
    protected String name = "3";
}

class Dog extends Animal {
    int age = 10;

    public synchronized void shout() {
        System.out.println("shout");

    }
}