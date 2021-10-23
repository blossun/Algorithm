package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] nodes = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            nodes[v1].add(v2);
            nodes[v2].add(v1);
        }

        // 출력할 결과
        int number = 1;
        int maxDistance = -1;
        int count = 0;

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(new Node(1, 0)); //첫번째 탐색 시작 지점
        visited[1] = true;
        count++;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (maxDistance < now.distance) {
                maxDistance = now.distance;
                number = now.to;
                count = 1;
            } else if (maxDistance == now.distance) { // 최대 거리가 같다면 추가
                count++;

                // 가장 작은 헛간이면 갱신
                if (number > now.to) {
                    number = now.to;
                }
            }

            for (Integer next : nodes[now.to]) {
                if (visited[next]) {
                    continue;
                }
                q.add(new Node(next, now.distance + 1));
                visited[next] = true;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" ").append(maxDistance).append(" ").append(count);
        System.out.println(sb.toString());
    }

    static class Node {
        int to;
        int distance;

        public Node(final int to, final int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
