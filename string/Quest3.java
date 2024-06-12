package string;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 1-3. 문장 속 단어
 */
public class Quest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String[] words = str.split(" ");
        int max = words[0].length();
        int idx = 0;
        for (int i = 1; i < words.length; i++) {
            if (max < words[i].length()) {
                max = words[i].length();
                idx = i;
            }
        }

        return words[idx];
    }
}
