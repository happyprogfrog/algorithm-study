package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-6. 뒤집은 소수
 */
public class Quest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] inputStrList = new String[n];
        for (int i = 0; i < n; i++) {
            inputStrList[i] = scanner.next();
        }

        ArrayList<Integer> answers = solution(n, inputStrList);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, String[] inputStrList) {
        ArrayList<Integer> answers = new ArrayList<>();
        for (String str : inputStrList) {
            String reversed = new StringBuilder(str).reverse().toString();
            if (isPrime(Integer.parseInt(reversed))) {
                answers.add(Integer.valueOf(reversed));
            }
        }

        return answers;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
