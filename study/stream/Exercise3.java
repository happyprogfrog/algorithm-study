package study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-3.php
 */
public class Exercise3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);

        // Sum of even numbers
        int sumOfEvens = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sumOfEvens);

        // Sum of odd numbers
        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of odd numbers: " + sumOfOdds);
    }
}
