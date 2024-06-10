package datastructure;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 4-3. 매출액의 종류
 */
public class Quest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> answers = solution(n, k, arr);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answers = new ArrayList<>();

        // sliding window 로 각 구간을 확인
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answers.add(map.size());

        for (int i = 1; i <= n - k; i++) {
            // 앞에껀 빼고
            map.put(arr[i - 1], map.get(arr[i - 1]) - 1);
            if (map.get(arr[i - 1]) == 0) {
                map.remove(arr[i - 1]);
            }

            // 뒤에껀 더한다
            map.put(arr[i + k - 1], map.getOrDefault(arr[i + k - 1], 0) + 1);

            // 매출액 종류 확인
            answers.add(map.size());
        }

        return answers;
    }
}
