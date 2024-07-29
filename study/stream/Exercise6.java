package study.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-6.php
 */
public class Exercise6 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println("Original List of strings(colors): " + colors);

        // Sort strings in ascending order
        List<String> ascendingOrder = colors.stream()
                .sorted()
                .toList();
        System.out.println("\nSorted in Ascending Order: " + ascendingOrder);

        // Sort strings in descending order
        List<String> descendingOrder = colors.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("\nSorted in Descending Order: " + descendingOrder);
    }
}
