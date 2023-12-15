package org.main.homework03;

public class Cat extends Animal {
    String owner;

    public Cat(String name, int age) {
        super(name, age);
    }

    void climb(String place) {
        System.out.println("Я лезу на " + place);
    }

    void makeSound() {
        System.out.println(name + ": мяу!");
    }
}
