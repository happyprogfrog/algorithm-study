package stackqueue;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 5-3. 크레인 인형뽑기(카카오)
 */
public class Quest3 {
    private static int n;
    private static int count;
    private static int[][] board;
    private static int[] games;
    private static ArrayList<Stack<Integer>> myBoard;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n][n];
        myBoard = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i <= n; i++) {
            myBoard.add(new Stack<>());
        }

        for (int col = 0; col < n; col++) {
            for (int row = n - 1; row >= 0; row--) {
                int num = board[row][col];
                if (num != 0) {
                    myBoard.get(col + 1).add(num); // 0번 칼럼은 사용 x, 0이 아닌 인형들만 담겨져 있음
                }
            }
        }

        count = scanner.nextInt();
        games = new int[count];
        for (int i = 0; i < count; i++) {
            games[i] = scanner.nextInt();
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int col : games) {
            if (!myBoard.get(col).isEmpty()) {
                // 꺼냄
                int pick = myBoard.get(col).pop();

                if (!stack.isEmpty()) {
                    // 바구니가 비어있지 않으므로, 바구니에 있는 값을 확인
                    int top = stack.peek();
                    if (top == pick) {
                        stack.pop(); // 바구니에 있는 거랑 같으면 바구니에 있는 걸 없앰
                        answer += 2; // 두 개의 인형이 사라짐
                    } else {
                        stack.push(pick); // 바구니에 있는 거랑 다르면 바구니에 집어넣음
                    }
                } else {
                    // 바구니가 비어있으므로, 집어넣음
                    stack.push(pick);
                }
            }
        }

        return answer;
    }
}
