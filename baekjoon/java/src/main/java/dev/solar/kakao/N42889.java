package dev.solar.kakao;

import java.util.*;

public class N42889 {
    public int[] solution(int N, int[] stages) {
        // 현재 스테이지에 있는 사람들의 수를 저장
        int[] currentStagePeople = new int[N+2];
        for (int stage : stages) {
            currentStagePeople[stage]++;
        }
        int[] passStagePeople = new int[N+2]; //해당 스테이지를 지나간 사람 수 = 총 인원 - 누적지나간 사람
        int totalPeople = stages.length; //총 인원
        int sumOfPelple = 0;
        for (int i = 1; i < N + 1; i++) {
            passStagePeople[i] = totalPeople - sumOfPelple;
            sumOfPelple += currentStagePeople[i];
        }
        // key(index) - value(실패율)로 저장
        Map<Integer, Double> order = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            double failure = (double) currentStagePeople[i] / passStagePeople[i];
            order.put(i, failure);
        }
        // value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        List<Map.Entry<Integer, Double>> orderList = new LinkedList<>(order.entrySet());

        Collections.sort(orderList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        int[] answer = new int[N];
        int i = 0;
        for (Iterator<Map.Entry<Integer, Double>> iter = orderList.iterator(); iter.hasNext(); ) {
            Map.Entry<Integer, Double> entry = iter.next();
            answer[i++] = entry.getKey();
        }
        return answer;
    }
}
