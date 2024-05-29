package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-12. 경로 탐색(인접 행렬)
 */
public class Quest11 {
    private static int v, answer = 0;
    private static int[][] graph;
    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        v = scanner.nextInt();
        int e = scanner.nextInt();
        graph = new int[v + 1][v + 1];
        check = new int[v + 1];
        for (int i = 0; i < e; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph[start][end] = 1;
        }

        check[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int n) {
        if (n == v) {
            answer++;
        } else {
            for (int i = 1; i <= v; i++) {
                if (graph[n][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs(i);
                    check[i] = 0;
                }
            }
        }
    }
}
