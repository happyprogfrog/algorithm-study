package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-8. 송아지 찾기
 */
public class Quest8 {
    private static final int[] distance = {1, -1, 5};
    private static int[] check = new int[10001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currPos = scanner.nextInt();
        int targetPos = scanner.nextInt();
        System.out.println(bfs(currPos, targetPos));
    }

    private static int bfs(int currPos, int targetPos) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(currPos);
        check[currPos] = 1;

        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size(); // 해당 레벨에 있는 노드의 개수
            for (int i = 0; i < len; i++) {
                int nowPos = q.poll();
                for (int dis : distance) {
                    int nextPos = nowPos + dis;
                    if (nextPos == targetPos) {
                        return level + 1;
                    }

                    if (nextPos >= 1 && nextPos <= 10000 && check[nextPos] == 0) {
                        check[nextPos] = 1;
                        q.offer(nextPos);
                    }
                }
            } // 해당 레벨을 모두 탐색 완료
            level++;
        }

        return 0;
    }
}
