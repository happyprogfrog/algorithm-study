package stackqueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-7. 교육과정설계
 */
public class Quest7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        String all = scanner.next();
        System.out.println(solution(target, all));
    }

    private static String solution(String target, String all) {
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            hashMap.put(ch, 0);
        }

        for (char ch : all.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                list.add(ch);
            }
        }

        String collected = list.stream().map(String::valueOf).collect(Collectors.joining());
        if (target.equals(collected)) {
            return "YES";
        }
        return "NO";
    }
}
