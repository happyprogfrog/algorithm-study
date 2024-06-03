package sorting;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 6-5. 중복 확인
 */
public class Quest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        System.out.print(solution(list));
    }

    private static String solution(ArrayList<Integer> list) {
        Collections.sort(list);

        String answer = "U";
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (num == list.get(i)) {
                answer = "D";
                return answer;
            }
            num = list.get(i);
        }

        return answer;
    }
}
