package dev.solar.level1;

import java.util.stream.IntStream;

public class FindAverage {
    public double solution(int[] arr) {
        return IntStream.of(arr).average().getAsDouble();
    }
}
