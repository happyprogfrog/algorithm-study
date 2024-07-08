package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-3. 가위 바위 보
 */
public class Quest3 {
    private static final int SCISSORS = 1;
    private static final int ROCK = 2;
    private static final int PAPER = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] infoA = new int[n];
        for (int i = 0; i < n; i++) {
            infoA[i] = scanner.nextInt();
        }

        int[] infoB = new int[n];
        for (int i = 0; i < n; i++) {
            infoB[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(solution(infoA[i], infoB[i]));
        }
    }

    private static char solution(int a, int b) {
        if (a == SCISSORS) {
            if (b == PAPER) return 'A';
            else if (b == ROCK) return 'B';
        } else if (a == ROCK) {
            if (b == SCISSORS) return 'A';
            else if (b == PAPER) return 'B';
        } else if (a == PAPER) {
            if (b == ROCK) return 'A';
            else if (b == SCISSORS) return 'B';
        }
        return 'D';
    }
}
