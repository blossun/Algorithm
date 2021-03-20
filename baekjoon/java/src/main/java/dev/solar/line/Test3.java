package dev.solar.line;

import java.util.*;

public class Test3 {
    public int[] solution(int[] enter, int[] leave) {
        Queue<Integer> exit = new LinkedList<>();
        HashMap<Integer, Integer> room = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int totalIn = 0;
        for (int i : leave) {
            exit.offer(i);
        }
        for (int i = 0; i < enter.length; i++) {
            totalIn++;
            // 자신의 입실 순서와 함께 방으로 입장
            room.put(enter[i], i);
            //나올 때, 총인원수 - 자신의 입실 순서
            while (!exit.isEmpty()) {
                if (!room.containsKey(exit.peek())) {
                    break;
                }
                Integer poll = exit.poll();
                room.get(poll);
            }
        }
        int[] answer = {};
        return answer;
    }
}
