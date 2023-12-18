package org.main.homework04;

import java.io.*;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десериализуйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите,
 * почему значение GPA не было сохранено/восстановлено.
 */
public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Владимир", 36, 4.1);
        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());
    }
}