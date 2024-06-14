package twopointers;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 3-3. 최대 매출
 */
public class Quest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int numOfDays = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, numOfDays));
    }

    private static int solution(int[] arr, int numOfDays) {
        // 처음 numOfDays 간의 매출을 구한다
        int sum = 0;
        for (int i = 0; i < numOfDays; i++) {
            sum += arr[i];
        }

        int answer = sum;

        // 그 다음은 앞에는 빼고, 뒤에는 더하면서 최고 매출을 구한다
        for (int i = 1; i <= arr.length - numOfDays; i++) {
            sum -= arr[i - 1];
            sum += arr[i + numOfDays - 1];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
