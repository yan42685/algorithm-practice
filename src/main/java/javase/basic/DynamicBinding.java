package javase.basic;

public class DynamicBinding {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();
        for (Animal animal : animals) {
            if (animal == null) {
                continue;
            }
            // 属性静态绑定
            animal.showTypeByAttribute();
            // 方法动态绑定
            animal.showTypeByMethod();

            if (animal instanceof Dog) {
                // 向下转型
                ((Dog) animal).shout();
            } else if (animal instanceof Cat) {
                ((Cat) animal).meow();
            }  else {
                System.out.println("运行类型是Animal");
            }

            System.out.println();
        }
        // null 可以用instanceof 关键字处理
        System.out.println(animals[2] instanceof Object);
    }
}
class Animal {
    String type = "Animal";
    public void showTypeByAttribute() {
        System.out.println("[static binding] type is " + this.type);
    }
    public void showTypeByMethod() {
        System.out.println("[dynamic binding] type is Animal");
    }
}

class Dog extends Animal{
    String type = "dog";
    @Override
    public void showTypeByMethod() {
        System.out.println("[dynamic binding] type is Dog");
    }
    public void shout() {
        System.out.println("The dog is shouting...");
    }
}

class Cat extends Animal {
    String type = "cat";
    @Override
    public void showTypeByMethod() {
        System.out.println("[dynamic binding] type is Cat");
    }
    public void meow() {
        System.out.println("The cat is meowing...");
    }
}