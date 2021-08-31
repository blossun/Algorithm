package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class N2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] network = new LinkedList[nodeCount + 1];
        boolean[] visited = new boolean[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            network[i] = new LinkedList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            String[] edge = br.readLine().split(" ");
            int n1 = Integer.parseInt(edge[0]);
            int n2 = Integer.parseInt(edge[1]);
            network[n1].add(n2);
            network[n2].add(n1);
        }
        visited[1] = true; //1번 노드 시작 시 방문 표시 후에 dfs를 호출해야 함
        dfs(network, visited, 1);
        int result = 0;
        for (boolean b : visited) {
            if (b) result++;
        }
        System.out.println(result - 1); //1번을 통해서 감염된 컴퓨터의 수 이니깐 1번 컴퓨터 갯수 제외
    }

    private static void dfs(final LinkedList<Integer>[] network, final boolean[] visited, final int cur) {
        for (int i = 0; i < network[cur].size(); i++) {
            int next = network[cur].get(i);
            if (visited[next]) continue;
            visited[next] = true;
            dfs(network, visited, next);
        }
    }
}
