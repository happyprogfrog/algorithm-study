package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-5. 동전 교환
 */
public class Quest18 {
    private static ArrayList<Integer> coins;
    private static int targetNum;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCoins = scanner.nextInt();
        coins = new ArrayList<>();
        for (int i = 0; i < numOfCoins; i++) {
            coins.add(scanner.nextInt());
        }
        coins.sort(Collections.reverseOrder());

        targetNum = scanner.nextInt();
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int level, int coinSum) {
        if (coinSum > targetNum) {
            return;
        }
        if (level >= answer) {
            return;
        }
        if (coinSum == targetNum) {
            answer = level;
        } else {
            for (int coin : coins) {
                dfs(level + 1, coinSum + coin);
            }
        }
    }
}
