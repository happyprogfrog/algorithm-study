package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-6. 친구인가?
 */
public class Quest6 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudent  = scanner.nextInt();
        int numOfPairs = scanner.nextInt();

        // 처음에는 다 개별집합으로 초기화
        parent = new int[numOfStudent + 1]; // 0번 인덱스는 사용하지 않음
        for (int i = 1; i <= numOfStudent; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < numOfPairs; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return parent[node];
        } else {
            return parent[node] = find(parent[node]);
        }
    }

    private static void union(int node_v, int node_u) {
        int fa = find(node_v);
        int fb = find(node_u);

        if (fa != fb) {
            parent[fa] = fb;
        }
    }
}
