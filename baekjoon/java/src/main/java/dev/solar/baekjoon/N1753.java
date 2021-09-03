package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(br.readLine());

        //서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
        //가장 짧은 간선만 저장하도록 HashMap에 (목적지, Node) 저장
        LinkedList<Node>[] graph = new LinkedList[V + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            // 방향 연결 그래프
            LinkedList<Node> nodes = graph[from];
            nodes.add(new Node(cost, to));
        }

        //최단 거리 테이블 초기화 - 시작점 : 0, 나머지 : 무한
        int[] D = new int[V + 1];
        int INF = 100_000_0001;
        Arrays.fill(D, INF);
        D[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        //1. (0, 시작점) 힙에 추가
        queue.add(new Node(0, start));

        //힙이 빌때까지 최단거리 테이블 갱신
        while (!queue.isEmpty()) {
            // 2. 힙에서 가장 거리가 작은 원소를 선택
            Node cur = queue.poll();
            // 3. 거리값이 최단 거리 테이블의 값과 같은지 확인
            if (cur.cost != D[cur.to]) { //쓸모없는 원소이므로 skip
                continue;
            }
            // 4. 뽑은 요소와 이웃한 정점의 최단거리를 갱신
            LinkedList<Node> nodes = graph[cur.to];
            for (Node node : nodes) {
                int newCost = node.cost + cur.cost;
                if (newCost < D[node.to]) {
                    D[node.to] = newCost;
                    queue.add(new Node(D[node.to], node.to));
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        Arrays.stream(D).skip(1).forEach(n -> {
            if (n == INF) {
                sb.append("INF").append("\n");
                return;
            }
            sb.append(n).append("\n");
        });
        System.out.println(sb.toString());

    }

    static class Node implements Comparable<Node> {
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
