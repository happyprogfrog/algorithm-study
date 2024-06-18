package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryReaderWriter {
    public static void main(String[] args) {
        String sample = "Hello, World!";
        List arrList = new ArrayList();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            arrList.add(sample);
        }

        arrList.stream().collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end-start) + " ms");
    }
}
