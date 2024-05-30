package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-3. 최대 점수 구하기
 */
public class Quest16 {
    private static int numOfQ;
    private static int limitTime;
    private static int answer = Integer.MIN_VALUE;

    private static class Q {
        int score;
        int time;

        public Q(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numOfQ = scanner.nextInt();
        limitTime = scanner.nextInt();

        ArrayList<Q> list = new ArrayList<>();
        for (int i = 0; i < numOfQ; i++) {
            int score = scanner.nextInt();
            int time = scanner.nextInt();
            list.add(new Q(score, time));
        }

        dfs(0, 0, 0, list);
        System.out.println(answer);
    }

    private static void dfs(int idx, int scoreSum, int timeSum, ArrayList<Q> list) {
        if (timeSum > limitTime) {
            return;
        }

        if (idx == numOfQ) {
            answer = Math.max(answer, scoreSum);
        } else {
            dfs(idx + 1, scoreSum + list.get(idx).score, timeSum + list.get(idx).time, list);
            dfs(idx + 1, scoreSum, timeSum, list);
        }
    }
}
