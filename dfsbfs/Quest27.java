package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-15. 피자 배달 거리
 */
public class Quest27 {
    private static int answer = Integer.MAX_VALUE;
    private static int choice;
    private static int[][] map;
    private static ArrayList<Pos> pizzaShopList = new ArrayList<>();
    private static ArrayList<Pos> houseList = new ArrayList<>();
    private static int[] combi;
    private static int len;

    private static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMap = scanner.nextInt();
        choice = scanner.nextInt();
        map = new int[sizeOfMap][sizeOfMap];
        combi = new int[choice];
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                int num = scanner.nextInt();
                map[i][j] = num;
                if (num == 1) {
                    houseList.add(new Pos(i, j));
                } else if (num == 2) {
                    pizzaShopList.add(new Pos(i, j));
                }
            }
        }

        len = pizzaShopList.size();

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int level, int start) {
        if (level == choice) {
            // 피자집을 다 골랐다!
            int sum = 0;
            for (Pos h : houseList) {
                int minDis = Integer.MAX_VALUE;
                for (int i : combi) {
                    minDis = Math.min(minDis, Math.abs(h.row - pizzaShopList.get(i).row) + Math.abs(h.col - pizzaShopList.get(i).col));
                }
                sum += minDis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < len; i++) {
                combi[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }
}
