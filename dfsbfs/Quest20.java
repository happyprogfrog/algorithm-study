package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-7. 조합의 경우수
 */
public class Quest20 {
    private static int[][] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        memo = new int[34][34]; // n은 최대 33이므로
        dfs(n, r);
        System.out.println(memo[n][r]);
    }

    private static int dfs(int n, int r) {
        if (memo[n][r] > 0) {
            return memo[n][r];
        }
        if (n == r || r == 0) {
            return memo[n][r] = 1;
        } else {
            return memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }
}
