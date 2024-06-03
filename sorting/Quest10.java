package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-10. 마구간
 */
public class Quest10 {
    private static ArrayList<Integer> list;
    private static int numOfAnimals;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfHouse = scanner.nextInt();
        numOfAnimals = scanner.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < numOfHouse; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int answer = 0;
        Collections.sort(list);

        int lt = 0;
        int rt = list.get(list.size() - 1);
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = calcCount(mid);
            if (count >= numOfAnimals) {
                // 더 많은 수의 동물을 마구간에 배치할 수 있으므로, 간격을 더 넓혀서 배치해볼 수 있다
                lt = mid + 1;
                answer = mid;
            } else {
                // 간격을 더 좁혀야, 마구간에 배치할 수 있다
                rt = mid - 1;
            }
        }

        return answer;
    }

    private static int calcCount(int distance) {
        int count = 1;
        int currDistance = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int nextDistance = list.get(i);
            if (distance <= nextDistance - currDistance) {
                count++;
                currDistance = list.get(i);
            }
        }
        return count;
    }
}
