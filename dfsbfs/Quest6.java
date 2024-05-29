package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-6. 부분 집합 구하기
 */
public class Quest6 {
    private static int[] arr;
    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        check = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, 0);
    }

    private static void dfs(int n, int level) {
        if (level == n) {
            for (int i = 0; i < n; i++) {
                if (check[i] != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        } else {
            check[level] = 1;
            dfs(n, level + 1);
            check[level] = 0;
            dfs(n, level + 1);
        }
    }
}
