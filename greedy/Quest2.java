package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-2. 회의실 배정
 */
public class Quest2 {
    private static class Time implements Comparable<Time> {
        public int start;
        public int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            // 종료 시간이 빠른 것 부터 정렬
            // 단, 종료 시간이 같으면 시작 시간이 빠른 것 부터 정렬
            int delta = this.end - o.end;
            if (delta == 0) {
                return this.start - o.start;
            }

            return delta;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            times.add(new Time(start, end));
        }

        System.out.println(solution(n, times));
    }

    private static int solution(int n, ArrayList<Time> times) {
        Collections.sort(times);
        int answer = 1; // 가장 첫 회의는 선택한다
        int end = times.get(0).end;

        for (int i = 1; i < n; i++) {
            if (times.get(i).start >= end) {
                answer++;
                end = times.get(i).end;
            }
        }

        return answer;
    }
}
