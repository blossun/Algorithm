package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class N49189 {
    public int solution(int n, int[][] edge) {
        List<Node>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        // 노드 정보 그래프
        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            graph[a].add(new Node(1, b));
            graph[b].add(new Node(1, a));
        }

        // 최단거리 테이블 초기화
        int[] D = new int[n + 1];
        int INF = 100_000_0001;
        Arrays.fill(D, INF);
        D[1] = 0;

        // 가장 멀리 떨어진 거리
        int max = 0;

        // 힙에 (0, 시작점) 추가
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 1));

        // 힙이 빌때까지 최단거리 테이블 갱신
        while (!queue.isEmpty()) {
            // 합에서 가장 거리가 작은 원소 선택
            Node cur = queue.poll();
            if (cur.cost != D[cur.to]) {
                continue;
            }

            List<Node> nodes = graph[cur.to];
            for (Node node : nodes) {
                int newCost = node.cost + cur.cost;
                if (newCost < D[node.to]) {
                    D[node.to] = newCost;
                    queue.add(new Node(newCost, node.to));
                    // 가장멀리 떨어진 거리 갱신
                    max = Math.max(max, newCost);
                }
            }
        }

        final int finalMax = max;
        return (int) Arrays.stream(D).filter(i -> i == finalMax).count();
    }

    private class Node implements Comparable<Node> {
        int cost;
        int to;

        public Node(final int cost, final int to) {
            this.cost = cost;
            this.to = to;
        }

        @Override
        public int compareTo(final Node o) {
            return this.cost - o.cost;
        }
    }
}
