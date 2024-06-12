package string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-6. 중복 문자 제거
 */
public class Quest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        return set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
