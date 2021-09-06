package dev.solar.programmers;

import java.util.HashMap;

public class N12978Fail {
    // key : 마을 번호, value : 다른 마을로 이동 거리 - HashMap(key : 마을번호, value : 이동거리)
    static HashMap<Integer, HashMap<Integer, Integer>> villageMap = new HashMap<>();
    boolean[] visited;
    boolean[] village;
    int size;

    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N + 2];
        village = new boolean[N + 2];
        size = N;
        for (int[] ints : road) {
            int from = ints[0];
            int to = ints[1];
            int time = ints[2];
            if (from > to) {
                int temp = to;
                to = from;
                from = temp;
            }
            HashMap<Integer, Integer> map;
            if (villageMap.containsKey(from)) {
                map = villageMap.get(from);
                if (!map.containsKey(to) || time < map.get(to) ) {
                    map.put(to, time);
                }
            } else {
                map = new HashMap<>();
                map.put(to, time);
            }
            villageMap.put(from, map);
        }

        visited[1] = true;
        bt(1, 0, K);


        int answer = 0;
        for (boolean v : village) {
            if (v) {
                answer++;
            }
        }
        return answer;
    }

    private void bt(final int from, final int n, final int k) {
        if (n > k) {
            return;
        }
        if (n == k) {
            village[from] = true;
            return;
        }

        village[from] = true;
        HashMap<Integer, Integer> map = villageMap.get(from);
        for (Integer next : map.keySet()) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            bt(next, n + map.get(next), k);
            visited[next] = false;
        }
    }
}
