package dp;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 10-6. 최대 점수 구하기
 */
public class Quest6 {
    static class Problem {
        public int score;
        public int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfQuests = scanner.nextInt();
        int givenTime = scanner.nextInt();
        ArrayList<Problem> problems = new ArrayList<>();
        for (int i = 0; i < numOfQuests; i++) {
            int score = scanner.nextInt();
            int time = scanner.nextInt();
            problems.add(new Problem(score, time));
        }

        System.out.println(solution(givenTime, problems));
    }

    private static int solution(int givenTime, ArrayList<Problem> problems) {
        int[] memo = new int[givenTime + 1]; // 0번 인덱스는 사용 안함 // n분에 풀 수 있는 최대 점수

        for (Problem p : problems) {
            // 문제를 한 번만 풀 수 있으므로 큰 값부터 갱신
            for (int t = givenTime; t >= p.time; t--) {
                memo[t] = Math.max(memo[t], memo[t - p.time] + p.score);
            }
        }

        return memo[givenTime];
    }
}
