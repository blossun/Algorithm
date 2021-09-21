package dev.solar.temp;

public class Woo05 {
    public int Solution(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += count(i);
        }
        return result;
    }

    private int count(final int number) {
        System.out.println("number =" + number);
        int count = 0;
        String numberString = String.valueOf(number);
        int length = numberString.length();
        for (int i = 0; i < length; i++) {
            int digit = numberString.charAt(i) - '0';
            // 0은 손뼉치지 않음
            if (digit != 0 && digit % 3 == 0) {
                count++;
            }
        }
        return count;
    }
}
