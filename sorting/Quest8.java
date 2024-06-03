package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-8. 이분 검색
 */
public class Quest8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int targetNum = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        // 정렬
        System.out.println(binarySearch(list, targetNum));
    }

    private static int binarySearch(ArrayList<Integer> list, int targetNum) {
        Collections.sort(list);

        int lt = 0;
        int rt = list.size() - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (list.get(mid) == targetNum) {
                return mid + 1;
            } else if (list.get(mid) < targetNum) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return 0;
    }
}
