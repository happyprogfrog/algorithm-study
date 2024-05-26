package dp;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 10-5. 동전교환
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCoins = scanner.nextInt();
        int[] coins = new int[numOfCoins];
        for (int i = 0; i < numOfCoins; i++) {
            coins[i] = scanner.nextInt();
        }
        int targetNum = scanner.nextInt();
        System.out.println(solution(coins, targetNum));
    }

    private static int solution(int[] coins, int targetNum) {
        int[] memo = new int[targetNum + 1]; // 0번 인덱스는 사용안함 // n원을 거슬러주기 위한 가장 적은 수의 동전
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int coin : coins) {
            for (int num = coin; num <= targetNum; num++) {
                if (memo[num] > memo[num - coin] + 1) {
                    memo[num] = memo[num - coin] + 1;
                }
            }
        }

        return memo[targetNum];
    }
}
