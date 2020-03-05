package dev.solar.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisiorArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> divisors = new ArrayList<>();
        for ( int n : arr) {
            if (n%divisor == 0) {
                divisors.add(n);
            }
        }
        if (divisors.size() == 0) {
            return new int[]{-1};
        }
        Arrays.sort(divisors.toArray());
//        int[] answer = new int[divisors.size()];
//        answer = divisors.toArray(answer);
        int[] answer = divisors.stream().mapToInt(n->n).sorted().toArray();
        return answer;
    }
}
