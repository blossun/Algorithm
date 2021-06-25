package dev.solar.programmers;

import java.util.Arrays;
import java.util.stream.Stream;

public class N12939 {
    public String solution(String s) {
        String[] numberStrings = s.split(" ");
        int[] numbers = Stream.of(numberStrings).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        return numbers[0] + " " + numbers[numbers.length - 1];
    }
}
