package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-2. 대소문자 변환
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int gap = 'A' - 'a';
        for (char ch : str.toCharArray()) {
            if (ch - 'Z' <= 0) {
                // 소문자 -> 대문자
                sb.append((char)(ch - gap));
            } else {
                // 대문자 -> 소문자
                sb.append((char)(ch + gap));
            }
        }

        return sb.toString();
    }
}
