package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-7. 회문 문자열
 */
public class Quest7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String newStr = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(newStr)) {
            return "YES";
        }
        return "NO";
    }
}
