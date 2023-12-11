package org.main.homework01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Program {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("Среднее значение всех четных чисел в списке: " + meanOdd(numbers));

    }

    private static double meanOdd(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).mapToDouble(num -> num).average().getAsDouble();
    }
}
