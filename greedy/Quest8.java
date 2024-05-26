package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-7. 원더랜드 - 프림
 */
public class Quest8 {
    private static class Edge implements Comparable<Edge> {
        public int nodeNum;
        public int cost;

        public Edge(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCities = scanner.nextInt();
        int numOfRoads = scanner.nextInt();

        int[] check = new int[numOfCities + 1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numOfCities + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfRoads; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();

            // 무방향 인접 리스트로 저장
            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }

        System.out.println(solution(check, graph));
    }

    private static int solution(int[] check, ArrayList<ArrayList<Edge>> graph) {
        int cost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 0)); // 가장 처음은 임의의 정점을 넣는다
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (check[now.nodeNum] == 0) { //
                check[now.nodeNum] = 1;
                cost += now.cost;
                for (Edge next : graph.get(now.nodeNum)) {
                    if (check[next.nodeNum] == 0) {
                        pq.offer(new Edge(next.nodeNum, next.cost));
                    }
                }
            }
        }

        return cost;
    }
}
