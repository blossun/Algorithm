package dev.solar.programmers;

import java.util.HashMap;

/*
 * [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
 */
public class N42578 {
    public int solution(String[][] clothesString) {
        // 의상의 종류 갯수만큼 최대의 조합이 나올 수 있다.
        HashMap<String, Integer> clothes = new HashMap<>();
        // 의상의 종류를 키값으로 의상을 저장
        for (String[] cloth : clothesString) {
            String kind = cloth[1];
            if (clothes.containsKey(kind)) {
                clothes.put(kind, clothes.get(kind) + 1);
            } else {
                clothes.put(kind, 1);
            }
        }
        int total = 1;
        for (String key : clothes.keySet()) {
            total *= clothes.get(key) + 1;
        }

        return total - 1;
    }
}
