package sorting;

import java.util.Scanner;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-3. 삽입 정렬
 */
public class Quest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = scanner.nextInt();
        }

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // 값을 하나 들고 있고, 이 값이 삽입될 위치를 찾는다
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) { // temp 보다 큰 모든 요소를 오른쪽으로 이동
                arr[j + 1] = arr[j];
                j -= 1;
            }

            arr[j + 1] = temp; // j가 멈춘 바로 그 뒤가 이 값이 삽입될 위치이다
        }
    }
}
