package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-5. 다익스트라 알고리즘
 */
public class Quest5 {
    private static class Edge implements Comparable<Edge> {
        public int nodeNum;
        public int cost;

        public Edge(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost == o.cost) {
                return this.nodeNum - o.nodeNum;
            }

            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfNodes = scanner.nextInt();
        int numOfEdges = scanner.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) { // 0번 인덱스 사용 안함
            graph.add(new ArrayList<>());
        }

        // 그래프 관계 입력 받기
        for (int i = 0; i < numOfEdges; i++) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();
            int cost = scanner.nextInt();
            graph.get(startNode).add(new Edge(endNode, cost));
        }

        solution(numOfNodes, graph);
    }

    private static void solution(int numOfNodes, ArrayList<ArrayList<Edge>> graph) {
        int[] dis = new int[numOfNodes + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[1] = 0; // 시작 정점의 최소 비용은 0
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            // 이미 저장된 최소 비용보다 큰 비용이라면 확인할 필요가 없다
            if (now.cost > dis[now.nodeNum]) {
                continue;
            }

            // 이 now 에 연결된 정점을 꺼내 비용을 확인하고, 최소 비용이면 갱신한다
            for (Edge next : graph.get(now.nodeNum)) {
                int tempCost = now.cost + next.cost;
                if (dis[next.nodeNum] > tempCost) {
                    dis[next.nodeNum] = tempCost;
                    pq.offer(new Edge(next.nodeNum, tempCost));
                }
            }
        }

        for (int i = 2; i <= numOfNodes; i++) {
            System.out.print(i + " : ");
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(dis[i]);
            }
        }
    }
}
