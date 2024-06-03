package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-4. LRU
 */
public class Quest4 {
    private static int sizeOfCache;
    private static int sizeOfJobs;
    private static int[] cache;
    private static int[] jobs;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sizeOfCache = scanner.nextInt();
        sizeOfJobs = scanner.nextInt();

        cache = new int[sizeOfCache];
        jobs = new int[sizeOfJobs];
        for (int i = 0; i < sizeOfJobs; i++) {
            jobs[i] = scanner.nextInt();
        }

        solution();

        for (int i = 0; i < sizeOfCache; i++) {
            System.out.print(cache[i] + " ");
        }
    }

    private static void solution() {
        for (int job : jobs) {
            int idx = find(job);
            if (idx > 0) {
                // 캐시 히트
                for (int i = idx - 1; i >= 0; i--) {
                    cache[i + 1] = cache[i];
                }
                cache[0] = job;
            } else {
                // 캐시 미스
                for (int i = sizeOfCache - 2; i >= 0; i--) {
                    cache[i + 1] = cache[i];
                }
                cache[0] = job;
            }
        }
    }

    private static int find(int val) {
        int idx = -1;
        for (int i = 0; i < sizeOfCache; i++) {
            if (cache[i] == val) {
                idx = i;
            }
        }

        return idx;
    }
}
