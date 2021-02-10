package dev.solar.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class N12915 {
    private int N;

    public String[] solution(String[] strings, int n) {
        N = n;
        String[] results = Arrays.stream(strings).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.charAt(n) - o2.charAt(n);
                if (result == 0) {
                    return o1.compareTo(o2);
                }
                return result;
            }
        }).toArray(String[]::new);
        return results;
    }

}
