package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-1. 올바른 괄호
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }

        return "NO";
    }
}
