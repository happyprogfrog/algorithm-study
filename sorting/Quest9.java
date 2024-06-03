package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-9. 뮤직비디오
 */
public class Quest9 {
    private static int targetCount;
    private static int sumLength = 0;
    private static int maxLength = Integer.MIN_VALUE;
    private static ArrayList<Integer> songs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfSongs = scanner.nextInt();
        songs = new ArrayList<>();
        targetCount = scanner.nextInt();
        for (int i = 0; i < numOfSongs; i++) {
            int num = scanner.nextInt();
            sumLength += num;
            maxLength = Math.max(maxLength, num);
            songs.add(num);
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int answer = 0;
        int lt = maxLength;
        int rt = sumLength;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = calcCount(mid);
            if (count <= targetCount) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static int calcCount(int length) {
        int count = 1;
        int sumLength = songs.get(0);
        for (int i = 1; i < songs.size(); i++) {
            int nextLength = sumLength + songs.get(i);
            if (nextLength > length) {
                count++;
                sumLength = songs.get(i);
            } else {
                sumLength = nextLength;
            }
        }
        return count;
    }
}
