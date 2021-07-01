package dev.solar.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class N42885 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int count = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            count++;
        }
        return count;
    }

    public int solution02(int[] people, int limit) { //효율성실패
        Arrays.sort(people);
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            int currentWeight = people[i];
            if (currentWeight == -1) {
                continue;
            }
            people[i] = -1;
            count++;
            for (int j = people.length - 1; j > i ; j--) {
                if (people[j] == -1) {
                    continue;
                }
                if (currentWeight + people[j] > limit) {
                    continue;
                }
                currentWeight += people[j];
                people[j] = -1;
            }
        }
        return count;
    }

    public int solution01(int[] people, int limit) {// 효율성 실패
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
