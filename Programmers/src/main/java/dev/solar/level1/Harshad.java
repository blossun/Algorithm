package dev.solar.level1;

public class Harshad {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String[] strDigits = String.valueOf(x).split("");
        for (int i = 0; i < strDigits.length; i++) {
            sum += Integer.parseInt(strDigits[i]);
        }
        return (x%sum) == 0;
    }
}
