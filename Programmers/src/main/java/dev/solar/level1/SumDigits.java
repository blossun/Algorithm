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
/*
* 숫자를 String으로 변환 후, 한자리씩 split한 뒤, 해당 값을 Integer로 변환하여 합을 구한다.*/
