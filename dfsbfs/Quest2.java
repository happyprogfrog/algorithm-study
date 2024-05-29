package dfsbfs;

import java.util.Scanner;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-2. 재귀함수를 이용한 이진수 출력
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        recursive(n);
    }

    private static void recursive(int n) {
        if (n < 1) {
            return;
        } else {
            int quotient = n / 2;
            int remainder = n % 2;
            recursive(quotient);
            System.out.print(remainder);
        }
    }
}
