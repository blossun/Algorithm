package dev.solar.programmers;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class N42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        for (int truck_weight : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck_weight);
                    currentWeight += truck_weight;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    currentWeight -= queue.poll();
                } else {
                    if (currentWeight + truck_weight <= weight) {
                        queue.add(truck_weight);
                        currentWeight += truck_weight;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        // 모든 트럭이 진입한 이후에 for을 빠져나온다. 즉, 진입한 트럭이 모두 지나가는 시간(bridge_length_을 더해줘야한다.
        return time + bridge_length;
    }
}
