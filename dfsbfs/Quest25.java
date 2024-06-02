package dfsbfs;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 8-12. 토마토
 */
public class Quest25 {
    private static final int RIPEN = 1;
    private static final int NO = -1;
    private static final int[] rows = {-1, 1, 0, 0};
    private static final int[] cols = {0, 0, -1, 1};
    private static int col;
    private static int row;
    private static int[][] info;
    private static int[][] check;
    private static Queue<Pos> q = new LinkedList<>();

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
        col = scanner.nextInt();
        row = scanner.nextInt();
        info = new int[row][col];
        check = new int[row][col];
        int beforeRipenSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                info[i][j] = scanner.nextInt();
                check[i][j] = -1; // 0부터 날짜를 세기위함
                beforeRipenSum++;
            }
        }

        // 이미 익은 토마토들을 시작점으로 다 넣어준다
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (info[i][j] == RIPEN) {
                    q.offer(new Pos(i, j));
                    check[i][j] = 0;
                }
            }
        }

        // 너비 우선 탐색 시작
        bfs();

        // 결과 확인
        int day = 0;
        int afterRipenSum = 0;
        boolean flag = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (info[i][j] != -1 && check[i][j] >= 0) {
                    // 토마토가 들어있는 칸이고, 익은 토마토들만 카운팅한다!
                    afterRipenSum++;
                    day = Math.max(day, check[i][j]);
                }

                if (info[i][j] != -1 && check[i][j] == -1) {
                    // 토마토가 들어있는 칸인데, 익지 않았다!
                    flag = true;
                }
            }
        }

        if (beforeRipenSum == afterRipenSum) {
            System.out.println(0);
        }
        else if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pos currPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = currPos.row + rows[i];
                int nextCol = currPos.col + cols[i];

                if (!isValid(nextRow, nextCol)) continue;
                if (info[nextRow][nextCol] == RIPEN || info[nextRow][nextCol] == NO) continue;
                if (check[nextRow][nextCol] != -1) continue;

                q.offer(new Pos(nextRow, nextCol));
                check[nextRow][nextCol] = check[currPos.row][currPos.col] + 1;
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}
