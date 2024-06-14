package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-2. 공통원소 구하기
 */
public class Quest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        ArrayList<Integer> answer = solution(arr1, arr2);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    private static ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                // 작은 쪽의 포인트를 움직인다
                p1++;
            } else {
                // 작은 쪽의 포인트를 움직인다
                p2++;
            }
        }

        return answer;
    }
}
