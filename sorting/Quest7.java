package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-7. 좌표 정렬
 */
public class Quest7 {
    private static class Pos implements Comparable<Pos> {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Pos> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Pos(x, y));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }
    }
}
