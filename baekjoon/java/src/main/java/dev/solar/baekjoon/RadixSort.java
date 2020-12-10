package dev.solar.baekjoon;

import java.util.*;

public class RadixSort {
    Map<Integer, Queue> bucket = new TreeMap<>(); //TreeMap : 중복을 허용하지 않고 Key 값을 기준으로 정렬을 해주는 자료구조. HashMap은 키순서 정렬X

    public int[] radixSort(int[] arr) {
        // 1. 65536진법 상의 1의 자리수로 정렬
        for (int i = 0; i < arr.length; i++) {
            // (bit and 연산) 65535와 and하면 그것이 곧 65536으로 나눈 나머지.
            int remainder = arr[i] & 65535; //나머지 연산으로 1의 자리를 구함
            Queue q = bucket.get(remainder);
            if (q == null) {
                q = new LinkedList();
            }
            q.add(arr[i]);
            bucket.put(remainder, q);
        }
        // 1번 정렬한 값으로 배열을 재위치 시킴
        int idx = 0;
        Iterator<Integer> iteratorKey = bucket.keySet().iterator(); //키값 오름차순 정렬
        while (iteratorKey.hasNext()) {
            Queue q = bucket.get(iteratorKey.next());
            while (!q.isEmpty()) {
                arr[idx++] = (int) q.poll();
            }
        }
        // bucket을 비우고 다시 채워넣어야 함
        bucket.clear();

        // 2. 65536진법 상의 65536의 자리수로 정렬
        for (int i = 0; i < arr.length; i++) {
            // 16만큼 right shift하면 65536으로 나눈 몫으로, 곧 65536의 자리수를 의미.
            int quotient = arr[i] >> 16;
            Queue q = bucket.get(quotient);
            if (q == null) {
                q = new LinkedList();
            }
            q.add(arr[i]);
            bucket.put(quotient, q);
        }

        idx = 0;
        iteratorKey = bucket.keySet().iterator(); //키값 오름차순 정렬
        while (iteratorKey.hasNext()) {
            Queue q = bucket.get(iteratorKey.next());
            while (!q.isEmpty()) {
                arr[idx++] = (int) q.poll();
            }
        }
        return arr;
    }
}
