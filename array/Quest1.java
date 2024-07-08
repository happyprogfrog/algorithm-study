package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-1. 큰 수 출력하기
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        solution(n, arr);
    }

    private static void solution(int n, int[] arr) {
        int prevNum = arr[0];
        System.out.print(prevNum + " ");

        for (int i = 1; i < n; i++) {
            int currNum = arr[i];
            if (prevNum < currNum) {
                System.out.print(currNum + " ");
            }

            prevNum = currNum;
        }
    }
}
