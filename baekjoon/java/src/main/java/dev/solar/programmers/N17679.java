package dev.solar.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N17679 {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(n -> queue.add(n));
        while (queue.size() > 1) {
            if (queue.peek() >= K) { //최소 스코필이 K이상인 경우
                return count;
            }
            int min = queue.poll();
            int min2th = queue.poll();
            int newScoville = min + (min2th * 2);
            queue.add(newScoville);
            count++;
        }

        return (!queue.isEmpty() && queue.peek() >= K) ? count : -1;
    }
}
