package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-13. 섬나라 아일랜드
 */
public class Quest26 {
    private static int n;
    private static int[][] map;
    private static int[][] check;

    //                        상 하 좌 우 좌상 좌하 우상 우하
    private static final int[] rows = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static final int[] cols = {0, 0, -1, 1, -1, -1, 1, 1};

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
        n = scanner.nextInt();
        map = new int[n][n];
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && check[i][j] == 0) {
                    // 탐색 시작
                    count++;
                    bfs(i, j, count);
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(int row, int col, int count) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(row, col));
        check[row][col] = count;

        while(!q.isEmpty()) {
            Pos currPos = q.poll();
            for (int i = 0; i < 8; i++) {
                int nextRow = currPos.row + rows[i];
                int nextCol = currPos.col + cols[i];

                if (!isValid(nextRow, nextCol)) continue;
                if (map[nextRow][nextCol] == 0) continue;
                if (check[nextRow][nextCol] > 0) continue;

                q.offer(new Pos(nextRow, nextCol));
                check[nextRow][nextCol] = count;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
