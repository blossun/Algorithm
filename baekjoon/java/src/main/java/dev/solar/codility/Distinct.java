package dev.solar.codility;

import java.util.HashSet;

public class Distinct {
    public int solution(int[] A) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int num : A) {
            integerHashSet.add(num);
        }
        return integerHashSet.size();
    }
}
