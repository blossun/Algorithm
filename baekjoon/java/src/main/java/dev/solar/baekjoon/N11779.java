package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

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

        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        // 다익스트라 알고리즘
        // 1. 최단거리 테이블 초기화 -  시작점 :0, 나머지 : 무한
        int[] D = new int[V + 1];
        int[] pre = new int[V + 1]; //경로 복원 테이블 - 직전에 어디를 방문했는지 기록
        int INF =  100_000_001;
        Arrays.fill(D, INF);
        D[start] = 0;

        // 2. 힙에 (0, 시작점) 추가
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, start));

        // 힙이 빌 때까지 최단 거리 테이블 갱신
        while (!queue.isEmpty()) {
            // 3. 힙에서 가장 비용이 적은 원소를 선택
            Node cur = queue.poll();

            // 4. 비용이 최단 거리 테이블의 값과 같은지 확인
            if (cur.cost != D[cur.to]) { // 다르면, 쓸모없는 원소이므로 skip
                continue;
            }

            // 5. 뽑은 요소와 이웃한 정점의 최단거리를 갱신
            LinkedList<Node> nodes = graph[cur.to];
            for (Node node : nodes) {
                int newCost = node.cost + cur.cost;
                if (newCost < D[node.to]) {
                    D[node.to] = newCost;
                    queue.add(new Node(D[node.to], node.to));
                    pre[node.to] = cur.to; //최단 거리 테이블이 갱신될 때 어디를 거쳐가면 되는지를 저장
                }
            }
        }

        // 경로복원
        // pre테이블로 도착지 -> 출발지로 경로 역추적
        List<Integer> path = new LinkedList<>();
        int cur = end;
        path.add(cur);
        while (cur != start) {
            path.add(pre[cur]);
            cur = pre[cur];
        }

        // 출력
        // 최소비용, 도시 갯수, 도시 순서
        StringBuilder sb = new StringBuilder();
        sb.append(D[end]).append("\n")
                .append(path.size()).append("\n");
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static class Node implements Comparable<Node> {
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
