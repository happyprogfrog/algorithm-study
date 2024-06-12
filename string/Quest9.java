package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-9. 숫자만 추출
 */
public class Quest9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        // 숫자만 추출
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }

        // 자연수로 변환
        return Integer.parseInt(sb.toString());
    }
}
