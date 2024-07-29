package study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-2.php
 */
public class Exercise2 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
        System.out.println("List of strings: " + colors);

        // Convert strings to uppercase using streams
        List<String> uppercaseStrings = colors.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("\nUppercase Strings: " + uppercaseStrings);

        // Convert strings to lowercase using streams
        List<String> lowercaseStrings = colors.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println("\nLowercase Strings: " + lowercaseStrings);
    }
}
