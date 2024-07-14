package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-6. 최대 길이 연속부분수열
 */
public class Quest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(len, target, arr));
    }

    private static int solution(int len, int target, int[] arr) {
        int lt = 0;
        int cnt = 0; // 0을 1로 바꾼 횟수
        int answer = 0;
        for (int rt = 0; rt < len; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt > target) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}
