package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-6. 공주 구하기
 */
public class Quest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int targetNum = scanner.nextInt();
        System.out.println(solution(n, targetNum));
    }

    private static int solution(int n, int targetNum) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i); // 1부터 n까지 넣는다
        }

        int count = 0;
        while (q.size() != 1) {
            count++;
            int curr = q.poll();
            if (count != targetNum) {
                q.offer(curr);
            } else {
                count = 0; // 다시 세기 시작한다
            }
        }

        return q.poll();
    }
}
