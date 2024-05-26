package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-4. 최대 수입 스케줄
 */
public class Quest4 {
    private static class Lecture {
        public int money;
        public int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxDay = 0;
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int day = scanner.nextInt();
            lectures.add(new Lecture(money, day));
            maxDay = Math.max(maxDay, day);
        }

        System.out.println(solution(maxDay, lectures));
    }

    private static int solution(int maxDay, ArrayList<Lecture> lectures) {
        int income = 0;

        // day 기준으로 내림차순
        lectures.sort((a, b) -> b.day - a.day);

        // 금액이 큰 순으로 먼저 뽑기 위한 우선 순위 큐
        PriorityQueue<Lecture> pq = new PriorityQueue<>((a, b) -> b.money - a.money);

        int i = 0;
        for (int day = maxDay; day >= 1; day--) {
            // day 보다 큰 lecture 를 pq에 넣기
            for (; i < lectures.size(); i++) {
                if (lectures.get(i).day >= day) {
                    pq.offer(lectures.get(i));
                } else {
                    break;
                }
            }

            // 그 중에서 가장 비싼 강연료를 꺼내서 더한다
            if (!pq.isEmpty()) {
                income += pq.poll().money;
            }
        }

        return income;
    }
}
