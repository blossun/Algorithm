package dev.solar.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class N42885 {
    public int solution(int[] people, int limit) {
        List<Integer> peopleList = Arrays.stream(people).boxed().collect(Collectors.toList());
        Collections.sort(peopleList);
        int count = 0;
        while (!peopleList.isEmpty()) {
            int currentWeight = peopleList.remove(0);
            count++;
            for (int i = peopleList.size() - 1; i >= 0; i--) {
                int weight = peopleList.get(i);
                // 뒤에서부터 확인하는 코드가 필요함
                if (currentWeight + weight > limit) {
                    continue;
                } else {
                    currentWeight += weight;
                }
                peopleList.remove(i);
            }
        }

        return count;
    }
}
