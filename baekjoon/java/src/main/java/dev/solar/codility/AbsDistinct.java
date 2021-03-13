package dev.solar.codility;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public int solution(int[] A) {
        Set<Integer> elements = new HashSet<>();
        boolean intMinValue = false;
        for (int number : A) {
            if (number < 0) {
                if (number == Integer.MIN_VALUE) {
                    intMinValue = true;
                } else {
                    elements.add(number * -1);
                }
            } else {
                elements.add(number);
            }
        }
        int count = elements.size();
        if (intMinValue) {
            count++;
        }
        return count;
    }
}
