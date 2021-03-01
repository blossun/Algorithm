package dev.solar.codility;

import java.util.Arrays;

public class PermCheck {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int check = 1;
        for (int number : arr) {
            if (check == number) {
                check++;
                continue;
            }
            return 0;
        }
        return 1;
    }
}
