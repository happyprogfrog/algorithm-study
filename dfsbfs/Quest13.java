package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-14. 그래프 최단거리(BFS)
 */
public class Quest13 {
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] check;
    private static int[] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        check = new int[v + 1];
        distance = new int[v + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.get(start).add(end);
        }

        bfs(1);
        for (int i = 2; i <= v; i++) {
            System.out.println(i + " : " + distance[i]);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        check[n] = 1;
        distance[n] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (check[next] == 0) {
                    q.offer(next);
                    check[next] = 1;
                    distance[next] = distance[now] + 1;
                }
            }
        }
    }
}
