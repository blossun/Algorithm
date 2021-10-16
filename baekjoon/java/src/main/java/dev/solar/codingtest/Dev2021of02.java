package dev.solar.codingtest;

import java.util.HashMap;
import java.util.HashSet;

public class Dev2021of02 {
    static HashSet<Integer> holidaysSet = new HashSet<>();
    static HashMap<Integer, String> dayOfWeek = new HashMap<>();

    public int solution(int leave, String day, int[] holidays) {
        // 공휴일 체크
        for (int holiday : holidays) {
            holidaysSet.add(holiday);
        }

        // 날짜별 요일 확인을 위한 dayOfWeek
        String[] stringOfDay = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int start = 0;
        for (int i = 0; i < stringOfDay.length; i++) {
            if (stringOfDay[i].equals(day)) {
                start = i;
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            dayOfWeek.put(i, stringOfDay[start]);
            start = (start + 1) % 7;
        }

        int max = 0;
        boolean[] useLeave = new boolean[31];
        int st = 1;
        int en = 1;
        int length = 0;
        while (en < 31) { // 1일 부터 30일 까지 확인
            if (!isWeekDay(en)) {
                en++;
                length++;
                max = Math.max(max, length);
                continue;
            }
            if (leave > 0) {
                leave--;
                useLeave[en] = true;
                en++;
                length++;
                max = Math.max(max, length);
                continue;
            }
            if (useLeave[st]) {
                leave++;
            }
            st++;
            length--;
//            en++;
        }


        return max;
    }

    public boolean isWeekDay(int today) {
        if (holidaysSet.contains(today)) {
            return false;
        }

        today = today % 7 == 0 ? 7 : today % 7;
        String todayString = dayOfWeek.get(today);
        if (todayString.equals("SAT") || todayString.equals("SUN")) {
            return false;
        }

        return true;
    }
}
