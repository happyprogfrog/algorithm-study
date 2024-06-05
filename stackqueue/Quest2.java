package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-2. 괄호문자제거
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop(); // ( 가 나올 때까지 pop
                }
                stack.pop(); // ( 제거
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
