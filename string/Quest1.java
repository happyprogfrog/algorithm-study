package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-1. 문자 찾기
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String target = scanner.next();
        System.out.println(solution(str, target));
    }

    private static int solution(String str, String target) {
        int answer = 0;
        for (char ch : str.toCharArray()) {
            if (String.valueOf(ch).equalsIgnoreCase(target)) {
                answer++;
            }
        }

        return answer;
    }
}
