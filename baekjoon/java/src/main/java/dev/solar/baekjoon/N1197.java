package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3 3
 * 1 2 1
 * 2 3 2
 * 1 3 3
 */
public class N1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 비방향 연결 그래프
        PriorityQueue<Node> graph = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, edge));
        }

        int result = spanningKruskal(V, graph);
        System.out.println(result);
    }

    private static int spanningKruskal(final int v, final PriorityQueue<Node> graph) {
        // 그룹(부모)정보 저장 - 같은 그룹인지 확인용
        int[] parent = new int[v + 1];
        int[] rank = new int[v + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //자기 자신의 그룹에 속하도록 초기화
        }

        int result = 0;
        int cnt = 0;
        while (!graph.isEmpty()) {
            Node node = graph.poll();
            if(isEqualParent(parent, node.a, node.b)) {
               continue;
            }
            result += node.cost;
            cnt++;
            union(parent, rank, node.a, node.b);
            if (cnt == v - 1) break;
        }
        return result;
    }

    public static void union(int[] parent, int[] rank, int prev, int cur) {
        int prevParent = getParent(parent, prev);
        int curParent = getParent(parent, cur);
        if (rank[prevParent] > rank[curParent]) {
            parent[curParent] = prevParent;
        } else {
            parent[prevParent] = curParent;
            if (rank[prevParent] == rank[curParent]) {
                rank[curParent]++;
            }
        }
    }

    public static boolean isEqualParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    private static int getParent(final int[] parent, final int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    static class Node implements Comparable<Node> {
        int a;
        int b;
        int cost;

        public Node(final int a, final int b, final int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return cost - o.cost;
        }
    }
}
