package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-8. 등수구하기
 */
public class Quest8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] rankList = solution(n, scores);
        for (int rank : rankList) {
            System.out.print(rank + " ");
        }
    }

    private static int[] solution(int n, int[] scores) {
        int[] rankList = new int[n];

        ArrayList<Integer> copyScores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            copyScores.add(scores[i]);
        }

        copyScores.sort(Collections.reverseOrder());

        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int score : copyScores) {
            if (!map.containsKey(score)) {
                map.put(score, rank);
            }
            rank++;
        }

        for (int i = 0; i < n; i++) {
            rankList[i] = map.get(scores[i]);
        }

        return rankList;
    }
}
