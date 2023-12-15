package org.main.homework03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

public class Program {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 3), new Dog("Бобик", 4), new Cat("Мурзик", 5)};

        for (Animal animal : animals) {
            classInfo(animal);
            System.out.println();
        }

        for (Animal animal : animals) {
            try {
                methodCall(animal, "makeSound");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Такого метода не существует у класса");
            }
        }

    }

    private static void classInfo(Animal animal) {
        Class<?> animalClass = animal.getClass();
        System.out.println("Имя класса: " + animalClass.getSimpleName());
        System.out.println("Поля класса: " + Arrays.toString(animalClass.getDeclaredFields()));
        System.out.println("Родительский класс: " + animalClass.getSuperclass());
        System.out.println("Методы класса: " + Arrays.toString(animalClass.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(animalClass.getConstructors()));
    }

    private static void methodCall(Animal animal, String makeSound) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> animalClass = animal.getClass();
        Method displayInfoMethod = animalClass.getDeclaredMethod(makeSound);
        displayInfoMethod.invoke(animal);
    }

}
