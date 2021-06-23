package dev.solar.programmers.challenge;

import java.util.Arrays;

public class N12982 {
    public int solution(int[] d, int budget) {
        // 최대로 지원해주려면 제일 예산이 적은 것부터 지원해주면 된다.
        Arrays.sort(d);
        int count = 0;
        for (int i : d) {
            if (i > budget) {
                break;
            }
            budget -= i;
            count++;
        }
        return count;
    }
}
