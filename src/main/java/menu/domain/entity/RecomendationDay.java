package menu.domain.entity;

public enum RecomendationDay {
    MONDAY(WeekDay.MONDAY),
    TUESDAY(WeekDay.TUESDAY),
    WEDNESDAY(WeekDay.WEDNESDAY),
    THURSDAY(WeekDay.THURSDAY),
    FRIDAY(WeekDay.FRIDAY);

    private final WeekDay weekDay;

    RecomendationDay(final WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }
}
