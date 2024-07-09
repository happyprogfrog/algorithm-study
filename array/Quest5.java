package array;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 2-5. 소수(에라토스테네스 체)
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> primeList = doSieveOfEratosthenes(n);
        System.out.println(primeList.size());
    }

    private static ArrayList<Integer> doSieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        // 모든 수를 소수로 가정
        Arrays.fill(isPrime, true);

        // 에라토스테네스의 체 알고리즘 적용
        for (int p = 2; p * p <= n; p++) {
            // isPrime[p]가 true이면 p는 소수
            if (isPrime[p]) {
                // p의 배수들은 모두 소수가 아니라고 표시
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        // 소수 출력
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

        return primeList;
    }
}
