package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-4. 연속 부분 수열
 */
public class Quest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, target));
    }

    private static int solution(int[] arr, int target) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == target) answer++;
            while (sum >= target) {
                sum -= arr[lt];
                lt++;
                if (sum == target) answer++;
            }
        }

        return answer;
    }
}
