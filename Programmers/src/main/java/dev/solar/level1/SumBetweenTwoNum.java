package dev.solar.level1;

import java.util.stream.LongStream;

public class SumBetweenTwoNum {
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        long answer = LongStream.rangeClosed(min, max).sum();
        return answer;
    }

    public static void main(String[] args) {
        SumBetweenTwoNum test = new SumBetweenTwoNum();
        long result = test.solution(3,3);
        System.out.println(result);
    }
}
/*
두 값을 Math클래스의 min(), max() 메서드로 작은 값, 큰 값을 구분하여 (min, max) 순서로 넘겨준다.
Long타입의 Stream을 열어서 rangeClosed(min, max) min부터 max(포함)까지의 값을 sum() 해준다.
*/
