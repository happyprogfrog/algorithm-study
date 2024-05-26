package dp;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 10-2. 돌다리 건너기
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] memo = new int[n + 2]; // 돌다리를 완전히 건너야함
        memo[1] = 1;
        memo[2] = 2;

        for(int i = 3; i <= n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n + 1];
    }
}
