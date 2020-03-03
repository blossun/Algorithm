package dev.solar.level1;

import java.util.stream.Stream;

public class SumDigits {
    public int solution(int n) {
        String num = String.valueOf(n);
        String[] nums = num.split("");
        int answer = Stream.of(nums).map(Integer::parseInt).reduce(0, Integer::sum);
        return answer;
    }
}
