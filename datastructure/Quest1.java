package datastructure;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 4-1. 학급회장
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(n, str));
    }

    private static Character solution(int n, String str) {
        int maxVal = Integer.MIN_VALUE;
        Character answer = null;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (maxVal < map.get(ch)) {
                maxVal = map.get(ch);
                answer = ch;
            }
        }

        return answer;
    }
}
