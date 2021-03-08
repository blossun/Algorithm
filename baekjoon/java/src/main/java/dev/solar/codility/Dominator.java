package dev.solar.codility;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public int solution(int[] A) {
        // key, value로 등장한 key : 숫자, value : 등장횟수를 저장하고,
        // 저장하면서 A.length의 절반만큼 등장했다면 해당 인덱스를 반환
        if (A.length == 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count > A.length / 2) {
                    return i;
                }
                map.put(num, count);
                continue;
            }
            map.put(num, 1);
        }
        return -1;
    }
}
