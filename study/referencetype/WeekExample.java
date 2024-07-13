package study.referencetype;

import java.util.Calendar;

public class WeekExample {
    public static void main(String[] args) {
        Week today = null;

        Calendar cal = Calendar.getInstance();

        // 오늘의 요일 얻기 (1 ~ 7)
        int week = cal.get(Calendar.DAY_OF_WEEK);

        // 숫자를 열거 상수로 변환해서 변수에 대입
        today = switch(week) {
            case 1 -> Week.SUNDAY;
            case 2 -> Week.MONDAY;
            case 3 -> Week.TUESDAY;
            case 4 -> Week.WEDNESDAY;
            case 5 -> Week.THURSDAY;
            case 6 -> Week.FRIDAY;
            case 7 -> Week.SATURDAY;
            default -> throw new IllegalArgumentException("Invalid week: " + week);
        };

        if (today == Week.SUNDAY) {
            System.out.println(today.getDescription());
            System.out.println("일요일에는 방청소를 합니다.");
        } else {
            System.out.println("열심히 자바를 공부합니다.");
        }
    }
}
