package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-10. 가장 짧은 문자 거리
 */
public class Quest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char target = scanner.next().charAt(0);

        int[] answers = solution(str, target);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private static int[] solution(String str, char target) {
        int cnt = 0;
        int idx = 0;
        boolean flag = false;
        int[] answers = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target) {
                cnt++;
                if (!flag)
                {
                    // 아직 목표 문자가 한번도 등장하지 않았다.
                    answers[i] = Integer.MAX_VALUE;
                } else {
                    answers[i] = cnt;
                }
            } else {
                // 목표하던 문자가 나왔다! cnt는 새롭게 시작해야하므로 리셋
                flag = true;
                cnt = 0;
                answers[i] = cnt;

                // 다시 뒤쪽으로 순회하면서, 필요 시 거리를 갱신
                int innerCnt = 0;
                for (int j = i - 1; j >= idx; j--) {
                    innerCnt++;
                    if (innerCnt < answers[j]) {
                        answers[j] = innerCnt;
                    }
                }
                idx = i;
            }
        }

        return answers;
    }
}
