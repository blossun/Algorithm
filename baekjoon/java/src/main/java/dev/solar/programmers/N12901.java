package dev.solar.programmers;

public class N12901 {

    public String solution(int a, int b) {
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 1; i < a; i++) {
            days += months[i];
        }
        days += b;
//        System.out.println("days : " + days);
//        System.out.println("days / 7 : " + days % 7);
        return day[(4 + days) % 7];
    }
}
