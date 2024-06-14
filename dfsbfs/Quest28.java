package dfsbfs;

import java.util.*;

/**
 * [백준] 2021번 최소 환승 경로
 * https://www.acmicpc.net/problem/2021
 */
public class Quest28 {
    static int numOfStations, numOfLines;
    static boolean[] visitedLine;
    static boolean[] visitedStation;
    static ArrayList<ArrayList<Integer>> stations;
    static ArrayList<ArrayList<Integer>> lines;

    private static class Node {
        int curLine;
        int curStation;
        int transCount;

        public Node(int curLine, int curStation, int transCount) {
            this.curLine = curLine;
            this.curStation = curStation;
            this.transCount = transCount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numOfStations = scanner.nextInt();
        numOfLines = scanner.nextInt();

        visitedStation = new boolean[numOfStations + 1]; // 0번 인덱스는 사용하지 않음
        visitedLine = new boolean[numOfLines + 1];
        stations = new ArrayList<>();
        lines = new ArrayList<>();

        for (int i = 0; i < numOfStations + 1; i++) {
            stations.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfLines + 1; i++) {
            lines.add(new ArrayList<>());
        }

        // 입력을 받는다
        for (int i = 1; i < numOfLines + 1; i++) {
            while(true) {
                int num = scanner.nextInt();
                if (num == -1) break;

                stations.get(num).add(i);
                lines.get(i).add(num);
            }
        }

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        int answer = bfs(start, end);
        System.out.println(answer);
    }

    private static int bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.transCount - b.transCount);

        visitedStation[start] = true;
        for (int line : stations.get(start)) {
            pq.add(new Node(line, start, 0));
            visitedLine[line] = true;
        }

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.curStation == end) {
                return now.transCount;
            }

            for (int nextStation : lines.get(now.curLine)) {
                if (!visitedStation[nextStation]) {
                    visitedStation[nextStation] = true;
                    pq.add(new Node(now.curLine, nextStation, now.transCount));

                    for (int nextLine : stations.get(nextStation)) {
                        if (!visitedLine[nextLine]) {
                            visitedLine[nextLine] = true;
                            pq.add(new Node(nextLine, nextStation, now.transCount + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
