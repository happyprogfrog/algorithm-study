package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-8. 유효한 팰린드롬
 */
public class Quest8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        // 알파벳만 찾아서 넣는다
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            }
        }

        String newStr = sb.toString();
        String reverseNewStr = new StringBuilder(sb).reverse().toString();
        if (newStr.equalsIgnoreCase(reverseNewStr)) {
            return "YES";
        }

        return "NO";
    }
}
