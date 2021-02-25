package dev.solar.codility;

import java.util.Arrays;

public class MaxCounters {
    public int[] solution(int maxNumber, int[] arr) {
        int[] counter = new int[maxNumber];
        int maxCounter = 0;
        for (int x : arr) {
            if (x >=1 && x <= maxNumber) {
                counter[x - 1]++;
                maxCounter = Math.max(maxCounter, counter[x - 1]);
            } else {
                Arrays.fill(counter, maxCounter);
            }
        }
        return counter;
    }
}
