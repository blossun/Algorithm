package dev.solar.codility;

import java.util.Arrays;

public class MaxCounters {
    public int[] solution(int maxNumber, int[] arr) {
        int[] counter = new int[maxNumber];
        int maxCounter = 0; //가진 원소 중 최댓값
        int tempMax = 0; //최소한의 값 (max counter을 실행하면 최소한 이 값 이상이어야 한다.)

        for (int x : arr) {
            if (x >= 1 && x <= maxNumber) {
                if (counter[x - 1] < tempMax) {
                    counter[x - 1] = tempMax + 1;
                } else {
                    counter[x - 1]++;
                }
                maxCounter = Math.max(maxCounter, counter[x - 1]); // 최댓값 갱신 //위 조건문 수행 후 밖에서 체크해야함
            } else {
                // 최소한의 값을 갱신
                tempMax = maxCounter;
            }
        }

        // 마지막에 최소한의 값 이하의 값을 가진 원소만 대상으로 갱신
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < tempMax) {
                counter[i] = tempMax;
            }
        }

        return counter;
    }
}
