package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-11. 문자열 압축
 */
public class Quest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        char prevCh = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            char currentCh = str.charAt(i);
            if (prevCh == currentCh) {
                cnt++;
            } else {
                sb.append(prevCh);
                if (cnt > 1) sb.append(cnt);
                prevCh = currentCh;
                cnt = 1;
            }
        }

        // 마지막 문자도 넣어준다
        sb.append(prevCh);
        if (cnt > 1) sb.append(cnt);

        return sb.toString();
    }
}
