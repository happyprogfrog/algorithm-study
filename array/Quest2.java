package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-2. 보이는 학생
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        int count = 1;
        int prevNum = arr[0];
        for (int i = 1; i < n; i++) {
            if (prevNum < arr[i]) {
                count++;
                prevNum = arr[i];
            }
        }

        return count;
    }
}
