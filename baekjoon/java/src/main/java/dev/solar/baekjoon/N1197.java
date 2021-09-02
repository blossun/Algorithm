package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

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
        int[] parent = new int[V + 1]; //같은 그룹인지 확인
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; //자기 자신의 그룹에 속하도록 초기화
        }

        // 비방향 연결 그래프
        ArrayList<Node> graph = new ArrayList<>(E);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, edge));
        }

        // 간선 저장 - 가충치 오름차순 정렬 필요
        Collections.sort(graph, Comparator.comparing(node -> node.cost));

        int result = 0;
        int cnt = 0;
        for (Node node : graph) {
            if(isEqualParent(parent, node.a, node.b)) {
               continue;
            }
            result += node.cost;
            cnt++;
            union(parent, node.a, node.b);
            if (cnt == V - 1) break;
        }
        System.out.println(result);
    }

    public static void union(int[] parent, int prev, int cur) {
        int prevParent = getParent(parent, prev);
        int curParent = getParent(parent, cur);
        if (prevParent <= curParent) {
            parent[curParent] = prevParent;
        } else {
            parent[prevParent] = curParent;
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

    static class Node {
        int a;
        int b;
        int cost;

        public Node(final int a, final int b, final int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
