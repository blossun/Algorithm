package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class N12978 {
    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new LinkedList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < road.length; i++) {
            int[] map = road[i];
            int from = map[0];
            int to = map[1];
            int cost = map[2];
            graph[from].add(new Node(cost, to));
            graph[to].add(new Node(cost, from));
        }
       return (int) dijkstra(N, K, graph);
    }

    private long dijkstra(final int N, final int K, final List<Node>[] graph) {
        // 최단거리 테이블 초기화
        long[] D = new long[N + 1]; //최단거리테이블
        long INF = 100_000_000_000_001L;
        Arrays.fill(D, INF);
        D[1] = 0;

        // 힙에 (0, 시작점) 추가
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 1));

        // 힙이 빌때까지 최단거리 테이블 갱신
        while (!queue.isEmpty()) {
            // 힙에서 가장 거리가 작은 원소 선택
            Node cur = queue.poll();
            if (cur.cost != D[cur.to]) { //해당 거리가 최단거리 테이블에 있는 값과 다르면 skip
                continue;
            }
            // 선택한 정점과 이웃한 정점의 최단거리를 갱신
            List<Node> nodes = graph[cur.to];
            for (Node node : nodes) {
                int newCost = node.cost + cur.cost;
                if (newCost < D[node.to]) {
                    D[node.to] = newCost;
                    queue.add(new Node(newCost, node.to));
                }
            }
        }
        return Arrays.stream(D).filter(cost -> cost <= K).count();
    }

    class Node implements Comparable<Node> {
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
