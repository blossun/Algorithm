package dev.solar.programmers;

import java.util.*;

public class N42746 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for (int number : numbers) {
            stringList.add(String.valueOf(number));
        }
        stringList.sort((num1, num2) -> (num2 + num1).compareTo(num1 + num2)); // 30, 3 -> 303, 330 중 330이 먼저
        // 앞이 0인 경우 뒷값도 0일 수 밖에 없다. 따라서 바로 0을 리턴
        if (stringList.get(0).equals("0")) {
            return "0";
        }
        for (String s : stringList) {
            sb.append(s);
        }
        return sb.toString();
    }

}
