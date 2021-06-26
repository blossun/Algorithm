package dev.solar.programmers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N42883 {
    public String solution(String number, int k) {
        String answer = "";

        List<Integer> numbers = Stream.of(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
        while (k > 0) {
            int left = 0;
            int right = 1;
            boolean removed = false;
//            if (right >= numbers.size()) { //마지막요소인 경우
            while (!removed) {
                if (left == numbers.size() - 1) { //마지막요소인 경우
                    k--;
                    numbers.remove(left);
                    removed = true;
                    continue;
                }
                if (numbers.get(left) < numbers.get(right)) {
                    k--;
                    numbers.remove(left);
                    removed = true;
                    continue;
                }
                left++;
                right++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : numbers) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
