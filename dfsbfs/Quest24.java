package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-11. 미로의 최단거리 통로
 */
public class Quest24 {
    private static final int SIZE = 7;
    private static int[][] maze = new int[SIZE + 1][SIZE + 1];
    private static int[][] check = new int[SIZE + 1][SIZE + 1];
    private static final int[] rows = {-1, 1, 0, 0};
    private static final int[] cols = {0, 0, -1, 1};

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
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        bfs();
        int answer = check[SIZE][SIZE] - 1;
        if (answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        int startRow = 1;
        int startCol = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(startRow, startCol));
        check[startRow][startCol] = 1;

        while(!q.isEmpty()) {
            Pos currPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = currPos.row + rows[i];
                int nextCol = currPos.col + cols[i];
                if (!isValid(nextRow, nextCol)) {
                    continue;
                }
                if (maze[nextRow][nextCol] == 1) {
                    continue;
                }
                if (check[nextRow][nextCol] != 0) {
                    continue;
                }

                q.offer(new Pos(nextRow, nextCol));
                check[nextRow][nextCol] = check[currPos.row][currPos.col] + 1;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 1 && row <= SIZE && col >= 1 && col <= SIZE;
    }
}
