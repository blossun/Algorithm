package dev.solar.programmers.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class N68644 {
    public int[] solution(int[] numbers) {
        // 결과 값이 중복저장되지 않도록 HashSet으로 저장
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> answerList = new ArrayList<>(result);
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
