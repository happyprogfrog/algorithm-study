package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-2. 바둑이 승차
 */
public class Quest15 {
    private static int answer = Integer.MIN_VALUE;
    private static int maxWeight;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        maxWeight = scanner.nextInt();
        n = scanner.nextInt();

        int[] dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = scanner.nextInt();
        }

        dfs(0, 0, dogs);
        System.out.println(answer);
    }

    private static void dfs(int idx, int sum, int[] dogs) {
        if (sum > maxWeight) {
            return;
        }
        if (idx == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(idx + 1, sum + dogs[idx], dogs);
            dfs(idx + 1, sum, dogs);
        }
    }
}
