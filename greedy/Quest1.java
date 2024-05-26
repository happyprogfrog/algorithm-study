package greedy;

import java.util.*;

/**
 * [인프런] 자바 알고리즘 문제풀이 입문
 * 9-1. 씨름 선수
 */
public class Quest1 {
    private static class Person {
        public int height;
        public int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            people.add(new Person(height, weight));
        }
        System.out.println(solution(n, people));
    }

    private static int solution(int n, ArrayList<Person> people) {
        int outNum = 0;
        people.sort((a, b) -> b.height - a.height); // 키 순으로 내림차순
        for (int i = 1; i < n; i++) {
            boolean outFlag = false;
            for (int j = i - 1; j >= 0; j--) {
                // i보다 j의 무게가 무겁다면 탈락
                if (people.get(i).weight < people.get(j).weight) {
                    outFlag = true;
                    break;
                }
            }

            if (outFlag) {
                outNum++;
            }
        }

        return n - outNum;
    }
}
