package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-4. 중복 순열
 */
public class Quest17 {
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] arr = new int[m];
        dfs(0, arr);
    }

    private static void dfs(int level, int[] arr) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[level] = i;
                dfs(level + 1, arr);
            }
        }
    }
}
