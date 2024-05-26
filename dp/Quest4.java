package dp;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 10-4. 가장 높은 탑 쌓기
 */
public class Quest4 {

    static class Brick implements Comparable<Brick> {
        public int width;
        public int height;
        public int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            // 넓이 기준으로 내림차순 정렬
            return o.width - this.width;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfBricks = scanner.nextInt();
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < numOfBricks; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            bricks.add(new Brick(width, height, weight));
        }

        Collections.sort(bricks);
        System.out.println(solution(numOfBricks, bricks));
    }

    private static int solution(int numOfBricks, ArrayList<Brick> bricks) {
        int answer = 0;
        int[] memo = new int[numOfBricks]; // 넓이 기준 내림차순 정렬된 벽돌에 인덱스를 부여하여, 해당 벽돌이 가장 위에 있을 때의 탑의 높이

        for (int i = 0; i < numOfBricks; i++) {
            memo[i] = bricks.get(i).height;
            for (int j = 0; j < i; j++) {
                // i 인덱스의 별도이 j 인덱스의 벽돌보다 가벼워야 올릴 수 있음
                if (bricks.get(i).weight < bricks.get(j).weight) {
                    memo[i] = Math.max(memo[i], memo[j] + bricks.get(i).height);
                }
            }
            answer = Math.max(answer, memo[i]);
        }

        return answer;
    }
}
