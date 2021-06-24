package dev.solar.programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        List<Integer> result = new LinkedList<>();
        int count = 0;
        int day = queue.element();
        while (!queue.isEmpty()) {
            Integer workDay = queue.remove();
            if (workDay <= day) {
                count++;
            } else {
                result.add(count);
                day = workDay;
                count = 1;
            }
        }
        result.add(count);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
