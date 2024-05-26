package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-7. 원더랜드 - 크루스칼
 */
public class Quest7 {
    private static int[] parent;
    private static int[] rank;

    private static class Road implements Comparable<Road> {
        public int start;
        public int end;
        public int cost;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCities = scanner.nextInt();
        int numOfRoads = scanner.nextInt();

        parent = new int[numOfCities + 1];
        rank = new int[numOfCities + 1];
        for (int i = 1; i <= numOfCities; i++) {
            parent[i] = i;
        }

        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < numOfRoads; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            roads.add(new Road(start, end, cost));
        }

        System.out.println(solution(roads));
    }

    private static int solution(ArrayList<Road> roads) {
        int cost = 0;
        Collections.sort(roads);
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

    private static int find(int city) {
        if (city == parent[city]) {
            return parent[city];
        } else {
            return parent[city] = find(parent[city]);
        }
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (rank[fa] > rank[fb]) {
            parent[fb] = parent[fa];
        } else {
            parent[fb] = parent[fa];
            if (rank[fa] == rank[fb]) {
                rank[fb] += 1;
            }
        }
    }
}
