package test;


import lombok.Getter;

import java.sql.SQLOutput;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        TreeSet<int[]> ints = new TreeSet<>((a, b) -> a[0] - b[0]);
        ints.add(new int[]{3});
        for (int[] x : ints) {
            System.out.println(x.getClass());
        }
        System.out.println(new boolean[]{}.getClass());
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