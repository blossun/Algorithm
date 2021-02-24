package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1260 {
    private static int nodeCount, edgeCount;
    private static LinkedList<Integer>[] nodeList;
    private static StringBuilder dfsResult = new StringBuilder();
    private static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCount = Integer.parseInt(st.nextToken()); //노드 개수
        edgeCount = Integer.parseInt(st.nextToken()); //간선 개
        int startNode = Integer.parseInt(st.nextToken()); //시작 노드

        nodeList = new LinkedList[nodeCount + 1];
        boolean[] bfsVisited = new boolean[nodeCount + 1];
        boolean[] dfsVisited = new boolean[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            nodeList[i] = new LinkedList();
        }
        while (edgeCount-- != 0) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodeList[node1].add(node2);
            nodeList[node2].add(node1);
            // 리스트 정렬 - (문제 조건) 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
//            Collections.sort(nodeList[node1]);
//            Collections.sort(nodeList[node2]);
        }

        // 리스트 정렬 - (문제 조건) 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
        for (int node = 1; node < nodeCount + 1; node++) {
            Collections.sort(nodeList[node]);
        }

        dfs(startNode, dfsVisited);
        bfs(startNode, bfsVisited);
        System.out.println(dfsResult);
        System.out.println(bfsResult);

    }

    private static void bfs(int currentNode, boolean[] bfsVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (!bfsVisited[currentNode]) {
                bfsVisited[currentNode] = true;
                bfsResult.append(currentNode).append(" ");
                queue.addAll(nodeList[currentNode]);
            }
        }
    }

    private static void dfs(int currentNode, boolean[] dfsVisited) {
        if (dfsVisited[currentNode]) { //방문했다면 skip
            return;
        }
        dfsVisited[currentNode] = true;
        dfsResult.append(currentNode).append(" ");
        for (int nextNode : nodeList[currentNode]) {
            dfs(nextNode, dfsVisited);
        }
    }

}
