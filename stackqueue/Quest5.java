package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-5. 쇠막대기
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char prevChar = str.charAt(0);
        stack.push(prevChar);
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (prevChar == '(' && currChar == ')') {
                // 레이저임
                stack.pop();
                answer += stack.size();
                prevChar = ')';
            } else if ((prevChar == ')' && currChar == '(') || (prevChar == '(' && currChar == '(')) {
                // 스택에 쌓는다
                stack.push(currChar);
                prevChar = '(';
            } else if (prevChar == ')' && currChar == ')') {
                // 쇠막대기 끝에 도달했으므로, 스택에서 하나 지우고 + 1
                stack.pop();
                answer += 1;
                prevChar = ')';
            }
        }

        return answer;
    }
}
