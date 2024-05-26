package greedy;

import java.util.*;

/**
 * [프로그래머스] 코딩테스트 고득점 kit
 * 탐욕법(Greedy) - 섬 연결하기
 */
class Quest9 {
    private static int[] parent;
    private static int[] rank;

    private static class Road implements Comparable<Road> {
        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int n, int[][] costs) {
        ArrayList<Road> roads = new ArrayList<>();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            roads.add(new Road(costs[i][0], costs[i][1], costs[i][2]));
        }

        // 비용 기준으로 정렬
        Collections.sort(roads);

        int cost = 0;
        for (Road road : roads) {
            int fa = find(road.start);
            int fb = find(road.end);
            if (fa != fb) {
                union(road.start, road.end);
                cost += road.cost;
            }
        }

        return cost;
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return parent[node];
        } else {
            return parent[node] = find(parent[node]);
        }
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (rank[fa] < rank[fb]) {
            parent[fa] = parent[fb];
        } else {
            parent[fb] = parent[fa];
            if (rank[fa] == rank[fb]) {
                rank[fa] += 1;
            }
        }
    }

    public static void main(String[] args) {
        Quest9 q = new Quest9();
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(q.solution(n, costs));
    }
}
