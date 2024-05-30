package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-1. 합이 같은 부분집합
 */
public class Quest14 {
    private static String answer = "NO";
    private static int total = 0;
    private static int n;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }

        dfs(0, 0, arr);
        System.out.println(answer);
    }

    private static void dfs(int idx, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (idx == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(idx + 1, sum + arr[idx], arr);
            dfs(idx + 1, sum, arr);
        }
    }
}
