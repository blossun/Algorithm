package dev.solar.codility;

import java.util.HashSet;
import java.util.Iterator;

public class OddOccurrencesInArray {

    public int solution(int[] arr) {

        HashSet<Integer> numberSet = new HashSet<>();
        for (int a : arr) {
            if (numberSet.contains(a)) {
                numberSet.remove(a);
            } else {
                numberSet.add(a);
            }
        }

        Iterator<Integer> it = numberSet.iterator();
        return it.next();
    }
}
