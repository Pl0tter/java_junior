package org.main.homework03;

public class Dog extends Animal {
    String home;

    public Dog(String name, int age) {
        super(name, age);
    }

    void protect(String place) {
        System.out.println("Я охраняю " + place);
    }
}
