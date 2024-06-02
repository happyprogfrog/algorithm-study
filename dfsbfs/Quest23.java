package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-10. 미로탐색
 */
public class Quest23 {
    private static int answer = 0;
    private static final int SIZE = 7;
    private static int[][] maze = new int[SIZE + 1][SIZE + 1];
    private static int[][] check = new int[SIZE + 1][SIZE + 1];
    private static final int[] rows = {-1, 1, 0, 0};
    private static final int[] cols = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        maze[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        if (row == SIZE && col == SIZE) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextRow = row + rows[i];
                int nextCol = col + cols[i];
                if (!isValid(nextRow, nextCol)) {
                    continue;
                }
                if (maze[nextRow][nextCol] == 1) {
                    continue;
                }
                if (check[nextRow][nextCol] == 1) {
                    continue;
                }
                check[nextRow][nextCol] = 1;
                dfs(nextRow, nextCol);
                check[nextRow][nextCol] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 1 && row <= SIZE && col >= 1 && col <= SIZE;
    }
}
