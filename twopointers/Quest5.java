package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-5. 연속된 자연수의 합
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int target = n / 2 + 1;
        int[] arr = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            arr[i] = i;
        }

        int answer = 0;
        int lt = 1;
        int sum = 0;
        for (int rt = 1; rt <= target; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
