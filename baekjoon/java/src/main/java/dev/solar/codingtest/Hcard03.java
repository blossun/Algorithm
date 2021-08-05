package dev.solar.codingtest;

import java.util.Arrays;
import java.util.HashSet;

public class Hcard03 {
    public int[] solution(int l1, int l2) {
        int min = Math.min(l1, l2);
        int max = Math.max(l1, l2);
        HashSet<Integer> result = new HashSet<>();
        result.add(min);
        result.add(max);
        while (true) {
            max -= min;
            if (max > 0) {
                result.add(max);
            } else {
                break;
            }
        }

        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        Arrays.sort(resultArray);
        return resultArray;
    }
}
