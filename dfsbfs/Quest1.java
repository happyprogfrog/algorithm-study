package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 7-1. 재귀함수
 */
public class Quest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        recursive(n);
    }

    private static void recursive(int n) {
        if (n < 1) {
            return;
        } else {
            recursive(n - 1);
            System.out.print(n + " ");
        }
    }
}
