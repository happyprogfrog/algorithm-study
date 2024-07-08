package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-4. 피보나치 수열
 */
public class Quest4 {
    private static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memo = new int[n + 1];
        fibo(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(memo[i] + " ");
        }
    }

    private static int fibo(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = 1;
            return memo[n];
        } else {
            return memo[n] = fibo(n - 1) + fibo(n - 2);
        }
    }
}
