package dev.solar.programmers.challenge;

import java.util.LinkedList;
import java.util.List;

public class N68935 {
    public int solution(int n) {
        List<Integer> three = new LinkedList<>();
        while (n >= 3) {
            three.add(n % 3);
            n /= 3;
        }
        three.add(n);

        int answer = 0;
        int digit = 1;
        for (int i = three.size() - 1; i >= 0 ; i--) {
            answer += three.get(i) * digit;
            digit *= 3;
        }
        return answer;
    }
}
