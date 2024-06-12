package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-12. 암호
 */
public class Quest12 {
    private static final int NUM = 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(n, str));
    }

    private static String solution(int n, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String tempStr = str.substring(i * NUM, (i + 1) * NUM);
            sb.append(changeToChar(tempStr));
        }

        return sb.toString();
    }

    private static char changeToChar(String str) {
        // # 과 * 를 이진수로 바꾸고, 문자로 변환
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        int val = Integer.parseInt(sb.toString(), 2);
        return (char) val;
    }
}
