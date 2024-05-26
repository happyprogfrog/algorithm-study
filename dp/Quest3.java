package dp;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 10-3. 최대 부분 증가수열
 */
public class Quest3 {
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
        int answer = 0;
        int[] memo = new int[n]; // 해당 인덱스가 마지막으로 왔을 때 최대 부분 증가 수열의 길이
        memo[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    if (max < memo[j]) {
                        max = memo[j];
                    }
                }
            }
            memo[i] = max + 1; // 내 앞에 있는 것들 중에 최대 부분 증가 수열을 찾아서 + 1
            answer = Math.max(answer, memo[i]);
        }

        return answer;
    }
}
