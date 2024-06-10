package datastructure;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 4-4. 모든 아나그램 찾기
 */
public class Quest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String target = scanner.next();
        System.out.println(solution(str, target));
    }

    private static int solution(String str, String target) {
        int answer = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int lp = 0;
        int rp = target.length() - 1;

        while (lp < str.length() && rp < str.length()) {
            Map<Character, Integer> copyMap = new HashMap<>(targetMap);
            for (int i = lp; i <= rp; i++) {
                char tempCh = str.charAt(i);
                if (copyMap.containsKey(tempCh)) {
                    copyMap.put(tempCh, copyMap.get(tempCh) - 1);
                    if (copyMap.get(tempCh) == 0) {
                        copyMap.remove(tempCh);
                    }
                }

                if (copyMap.isEmpty()) {
                    answer++;
                }
            }

            lp++;
            rp++;
        }

        return answer;
    }
}
