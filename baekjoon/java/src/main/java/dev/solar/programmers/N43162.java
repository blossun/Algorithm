package dev.solar.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class N43162 {

    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>(); //노드 번호를 담는다.
        for (int i = 0; i < n; i++) {
            if (visited[i]) { //이미 방문했으면 skip
                continue;
            }
            queue.add(i);
            visited[i] = true; //방문표시
            count++; //새로운 영역 갯수 증가
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                for (int j = 0; j < computers[cur].length; j++) {
                    if (visited[j] || computers[cur][j] == 0) continue; //이미 방문했거나 컴퓨터가 없는 경우
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
        return count;
    }
}
