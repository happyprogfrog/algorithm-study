package study.referencetype;

public enum Week {
    SUNDAY("Sunday is the weekend!"),
    MONDAY("Monday is the start of the week."),
    TUESDAY("Tuesday is the second day."),
    WEDNESDAY("Wednesday is the midweek."),
    THURSDAY("Thursday is almost the weekend."),
    FRIDAY("Friday is the end of the work week."),
    SATURDAY("Saturday is the weekend!");

    private String description;

    Week(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
