package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-13. 경로 탐색(인접 리스트)
 */
public class Quest12 {
    private static int v, answer = 0;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        v = scanner.nextInt();
        int e = scanner.nextInt();
        graph = new ArrayList<>();
        check = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.get(start).add(end);
        }

        check[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int n) {
        if (n == v) {
            answer++;
        } else {
            for (int next : graph.get(n)) {
                if (check[next] == 0) {
                    check[next] = 1;
                    dfs(next);
                    check[next] = 0;
                }
            }
        }
    }
}
