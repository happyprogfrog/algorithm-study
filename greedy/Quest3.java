package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-3. 결혼식
 */
public class Quest3 {
    private static class Time implements Comparable<Time> {
        static final int START = 1;
        static final int END = -1;

        int time;
        int flag;

        public Time(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }

        @Override
        public int compareTo(Time o) {
            // 시간이 빠른 순으로 정렬
            // 단, 시작이 같다면 제외를 먼저 진행하기 위해 종료 플래그인 것을 앞으로 정렬
            if (this.time == o.time) {
                return this.flag - o.flag;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            times.add(new Time(start, Time.START));
            times.add(new Time(end, Time.END));
        }

        System.out.println(solution(times));
    }

    private static int solution(ArrayList<Time> times) {
        Collections.sort(times);
        int answer = 0;
        int count = 0;
        for (Time time : times) {
            if (time.flag == Time.START) {
                count++;
            } else {
                count--;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
