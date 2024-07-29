package study.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-8.php
 */
public class Exercise8 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        System.out.println("List of numbers: " + nums);

        // Find the second smallest element
        Integer secondSmallest = nums.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        // Find the second largest element
        Integer secondLargest = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        Integer secondLargestV2 = nums.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);


        System.out.println("\nSecond smallest element: " + secondSmallest);
        System.out.println("\nSecond largest element V1: " + secondLargest);
        System.out.println("\nSecond largest element V2: " + secondLargestV2);
    }
}
