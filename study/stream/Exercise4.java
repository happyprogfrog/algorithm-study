package study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-4.php
 */
public class Exercise4 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        System.out.println("Original List of numbers: " + nums);

        // Remove duplicates
        List<Integer> distinctNumbers = nums.stream()
                .distinct()
                .toList();
        System.out.println("After removing duplicates from the said list: " + distinctNumbers);
    }
}
