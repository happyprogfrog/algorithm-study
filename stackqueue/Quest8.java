package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-8. 응급실
 */
public class Quest8 {
    private static ArrayList<Integer> dangers;
    private static Queue<Patient> patients;
    private static int targetIdx;

    private static class Patient {
        int index;
        int degreeOfDanger;

        public Patient(int index, int degreeOfDanger) {
            this.index = index;
            this.degreeOfDanger = degreeOfDanger;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        targetIdx = scanner.nextInt();
        dangers = new ArrayList<>();
        patients = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            dangers.add(num);
            patients.offer(new Patient(i, num));
        }

        System.out.println(solution());
    }

    private static int solution() {
        // 위험도를 내림차순으로 정렬
        dangers.sort(Collections.reverseOrder());

        int rank = 0;
        while (true) {
            Patient curr = patients.poll();
            if (curr.degreeOfDanger == dangers.get(rank)) {
                // 우선순위가 가장 높은 환자이다!
                if (curr.index == targetIdx) {
                    return rank + 1;
                } else {
                    rank++; // 다음 우선순위로...
                }
            } else {
                // 이것보다 큰 우선순위가 있으므로, 맨 뒤로
                patients.offer(curr);
            }
        }
    }
}
