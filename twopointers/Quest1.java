package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-1. 두 배열 합치기
 */
public class Quest1 {
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
        ArrayList<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                // arr1에 있는 원소를 넣고, p1을 증가
                list.add(arr1[p1]);
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                // arr2에 있는 원소를 넣고, p2를 증가
                list.add(arr2[p2]);
                p2++;
            } else {
                list.add(arr1[p1]);
                list.add(arr2[p2]);
                p1++;
                p2++;
            }
        }

        // 미처 못 넣은 나머지 부분들 넣기
        for (int i = p1; i < arr1.length; i++) {
            list.add(arr1[i]);
        }

        for (int i = p2; i < arr2.length; i++) {
            list.add(arr2[i]);
        }

        return list;
    }
}
