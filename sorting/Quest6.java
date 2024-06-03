package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-6. 장난꾸러기
 */
public class Quest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> originalList = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            originalList.add(num);
            sortedList.add(num);
        }

        Collections.sort(sortedList);

        for (int i = 0; i < n; i++) {
            if (!originalList.get(i).equals(sortedList.get(i))) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
