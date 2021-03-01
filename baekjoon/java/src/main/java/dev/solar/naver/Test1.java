package dev.solar.naver;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test1 {
    public int solution(String[] departments) {
        // write your code in Java SE 8
        int[] isAppeared = new int[5];
        for (String department : departments) {
            if (department.equals("Cardiology")) {
                isAppeared[0]++;
            } else if (department.equals("Neurology")) {
                isAppeared[1]++;
            } else if (department.equals("Orthopaedics")) {
                isAppeared[2]++;
            } else if (department.equals("Gynaecology")) {
                isAppeared[3]++;
            } else {
                isAppeared[4]++;
            }
        }
//        Arrays.sort(isAppeared);
//        return isAppeared[4];
        return Arrays.stream(isAppeared).max().getAsInt();
    }
}
