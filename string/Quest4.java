package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-4. 단어 뒤집기
 */
public class Quest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        String[] newArr = solution(arr);
        for (String str : newArr) {
            System.out.println(str);
        }
    }

    private static String[] solution(String[] arr) {
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = new StringBuilder(arr[i]).reverse().toString();
        }

        return newArr;
    }
}
