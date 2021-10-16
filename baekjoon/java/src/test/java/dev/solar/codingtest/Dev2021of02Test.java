package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Dev2021of02Test {
    Dev2021of02 dev2021of02 = new Dev2021of02();

    @Test
    void case01() {
        int leave = 4;
        String day = "FRI";
        int[] holidays = {6, 21, 23, 27, 28};
        int expected = 10;
        assertEquals(expected, dev2021of02.solution(leave, day, holidays));
    }

    @Test
    void temp() {
        String day = "FRI";

        String[] stringOfDay = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int start = 0;
        for (int i = 0; i < stringOfDay.length; i++) {
            if (stringOfDay[i].equals(day)) {
                start = i;
                break;
            }
        }
        HashMap<Integer, String> dayOfWeek = new HashMap<>();
        for (int i = 1; i < 8; i++) {
            dayOfWeek.put(i, stringOfDay[start]);
            start = (start + 1) % 7;
        }

        System.out.println(dayOfWeek.get(2));
        System.out.println(dayOfWeek.get(3));
        System.out.println(dayOfWeek.get(4));
        System.out.println(dayOfWeek.get(5));
        System.out.println(dayOfWeek.get(6));
        System.out.println(dayOfWeek.get(7));
        System.out.println(dayOfWeek.get(8));
        System.out.println(dayOfWeek.get(9));
        System.out.println(dayOfWeek.get(10));
        System.out.println(dayOfWeek.get(11));
    }
}
