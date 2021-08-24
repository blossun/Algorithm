package dev.solar.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N42628 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) {
                queue.add(Integer.valueOf(op[1]));
                continue;
            }
            if (op[0].equals("D")) {
                if (op[1].equals("1")) {
                    queue.poll();
                } else {
                    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                    minHeap.addAll(queue);
                    minHeap.poll();
                    queue.clear();
                    queue.addAll(minHeap);
                }
            }
        }

        if (queue.isEmpty()) {
            return new int[]{0, 0};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer number : queue) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        return new int[]{max, min};
    }
}
