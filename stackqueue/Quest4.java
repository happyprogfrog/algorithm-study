package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-4. 후위식 연산(postfix)
 */
public class Quest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<String> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            // 연산자이면, 두 개를 꺼내 연산을 진행
            if (ch == '+') {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a + b));

            } else if (ch == '-') {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a - b));

            } else if (ch == '*') {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a * b));

            } else if (ch == '/') {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a / b));
            } else {
                // 스택에 집어 넣는다
                stack.push(Character.toString(ch));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
