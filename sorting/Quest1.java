package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-1. 선택정렬
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = scanner.nextInt();
        }

        selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minValIdx]) {
                    minValIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValIdx];
            arr[minValIdx] = temp;
        }
    }
}
