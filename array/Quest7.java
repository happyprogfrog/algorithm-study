package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-7. 점수계산
 */
public class Quest7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int sum = 0;

        int score = 0;
        for (int num : arr) {
            if (num == 0) {
                score = 0;
            } else {
                score++;
                sum += score;
            }
        }

        return sum;
    }
}
