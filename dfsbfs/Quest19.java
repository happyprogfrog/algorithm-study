package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-6. 순열 구하기
 */
public class Quest19 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[m];
        check = new int[n];
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        dfs(0, numbers);
    }

    private static void dfs(int level, int[] numbers) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    arr[level] = numbers[i];
                    dfs(level + 1, numbers);
                    check[i] = 0;
                }
            }
        }
    }
}
