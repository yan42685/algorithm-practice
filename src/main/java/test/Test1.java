package test;


import lombok.Getter;

import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println(dog.age);
        System.out.println(dog.getAge());

    }

}

@Getter
class Animal {
    final String type = "test";
    int age = 1;
    protected String name = "3";
}

@Getter
class Dog extends Animal {
    int age = 10;

    public synchronized void shout() {
        System.out.println("shout");

    }
}