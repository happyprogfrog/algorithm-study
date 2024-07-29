package study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.w3resource.com/java-exercises/stream/java-stream-exercise-7.php
 */
public class Exercise7 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        System.out.println("Original list of numbers: " + nums);

        // Find the maximum value
        Integer maxVal = nums.stream()
                .max(Integer::compare)
                .orElse(null);


        // Find the minimum value
        Integer minVal = nums.stream()
                .min(Integer::compare)
                .orElse(null);

        System.out.println("\nMaximum value of the said list: " + maxVal);
        System.out.println("\nMinimum value of the said list: " + minVal);
    }
}
