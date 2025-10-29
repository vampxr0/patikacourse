package week5.Enums;

public enum Day {
    SUNDAY(1,"",""),
    MONDAY(2,"09:00","17:00"),
    TUESDAY(3,"10:00","18:00"),
    WEDNESDAY(4,"08:00","16:00"),
    THURSDAY(5,"12:00","20:00"),
    FRIDAY(6,"13:00","21:00"),
    SATURDAY(7,"","");

    private int day;
    private String startTime;
    private String finishTime;

    Day(int day, String startTime, String finishTime) {
        this.day = day;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }
}