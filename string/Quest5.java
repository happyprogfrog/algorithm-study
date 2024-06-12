package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-5. 특정 문자 뒤집기
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        char[] answers = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                answers[str.length() - i - 1] = str.charAt(i);
            } else {
                answers[i] = str.charAt(i);
            }
        }

        return String.valueOf(answers);
    }
}
