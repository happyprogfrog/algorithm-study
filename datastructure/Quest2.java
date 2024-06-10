package datastructure;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 4-2. 아나그램
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(solution(a, b));
    }

    private static String solution(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : a.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : b.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        if (!map.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
}
