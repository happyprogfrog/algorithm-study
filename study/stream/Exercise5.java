package study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-5.php
 */
public class Exercise5 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println("Original list of strings (colors): " + colors);

        // Count strings starting with a specific letter
        char startingLetter1 = 'B';
        long count1 = colors.stream()
                .filter(s -> s.startsWith(String.valueOf(startingLetter1)))
                .count();
        System.out.println("\nNumber of colors starting with '" + startingLetter1 + "': " + count1);

        // Count strings starting with a specific letter
        char startingLetter2 = 'Y';
        long count2 = colors.stream()
                .filter(s -> s.startsWith(String.valueOf(startingLetter2)))
                .count();
        System.out.println("\nNumber of colors starting with '" + startingLetter2 + "': " + count2);
    }
}
