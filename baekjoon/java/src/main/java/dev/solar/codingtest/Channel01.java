package dev.solar.codingtest;

import java.time.LocalTime;

public class Channel01 {
    public String solution(String timeStr, int sec) {
        // String 시간 표현을 24시간 단위의 시간 표현을 위한 TimeExpression 객체 생성
        TimeExpression timeExpression = TimeExpression.convertTime(timeStr);
        LocalTime time = LocalTime.of(timeExpression.hour, timeExpression.min, timeExpression.sec);
        time = time.plusSeconds(sec);
        return new StringBuilder().append(
                String.format("%02d", time.getHour()))
                .append(":")
                .append(String.format("%02d", time.getMinute()))
                .append(":")
                .append(String.format("%02d", time.getSecond()))
                .toString();
    }

}

class TimeExpression {
    int hour;
    int min;
    int sec;

    public TimeExpression(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public static TimeExpression convertTime(String timeStr) {
        String[] split = timeStr.split(" ");
        String timeslot = split[0];
        String[] time = split[1].split(":");
        TimeExpression timeExpression = new TimeExpression(Integer.parseInt(time[0]),
                Integer.parseInt(time[1]),
                Integer.parseInt(time[2]));
        if (timeslot.equals("PM")) {
            timeExpression.hour += 12;
        }
        if (timeslot.equals("PM") && timeExpression.hour == 24) {
            timeExpression.hour = 12;
        }
        if (timeslot.equals("AM") && timeExpression.hour == 12) {
            timeExpression.hour = 0;
        }
        return timeExpression;
    }
}
