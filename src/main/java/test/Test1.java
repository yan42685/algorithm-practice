package test;



public class Test1 {

    public static void main(String[] args) {
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