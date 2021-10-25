package dev.solar.codingtest;

import java.util.Arrays;

public class NHN02 {
    public int solution(int numOfRegin, int numOfArrackableFrequency, int[][] frequencies) {
        // 주파수 배열
        int[] countArray = new int[22];
        for (int i = 0; i < numOfRegin; i++) {
            int[] frequency = frequencies[i];
            for (int j = 1; j < frequency.length; j++) {
                System.out.print(frequency[j]);
                countArray[frequency[j]]++;
            }
            System.out.println();
        }
        for (int i : countArray) {
            System.out.println(i);
        }
        Arrays.sort(countArray);
        int result = 0;
        for (int i = 0; i < numOfArrackableFrequency; i++) {
            result += countArray[countArray.length - 1 - i];
            System.out.println(result);
        }
        System.out.println(result);
        return result;
    }
}
