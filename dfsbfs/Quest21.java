package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-8. 수열 추측하기
 */
public class Quest21 {
    private static int n;
    private static int target;
    private static int[][] memo;
    private static int[] check;
    private static int[] arr;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        target = scanner.nextInt();

        check = new int[n + 1];
        arr = new int[n];

        // 조합수 구해놓기
        memo = new int[11][11];
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                combination(i, j);
            }
        }

        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        // 조합 구하기
        dfs(0);
    }

    private static void dfs(int level) {
        if (flag) {
            return;
        }
        if (level == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (memo[n - 1][i] * arr[i]);
            }
            if (target == sum) {
                flag = true;
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    arr[level] = i;
                    dfs(level + 1);
                    check[i] = 0;
                }
            }
        }
    }

    private static int combination(int n, int r) {
        if (memo[n][r] > 0) {
            return memo[n][r];
        }
        if (n == r || r == 0) {
            return memo[n][r] = 1;
        } else {
            return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
