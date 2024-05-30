package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-9. 조합 구하기
 */
public class Quest22 {
    private static int n;
    private static int choice;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        choice = scanner.nextInt();
        arr = new int[choice];
        dfs(0, 1);
    }

    private static void dfs(int level, int start) {
        if (level == choice) {
            for (int i = 0; i < choice; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                arr[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }
}
