package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-4. 피보나치 수열
 */
public class Quest4 {
    private static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static int fibonacci(int n) {
        if (memo[n] > 0) return memo[n];
        if (n <= 1) return memo[n] = n;
        else return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
