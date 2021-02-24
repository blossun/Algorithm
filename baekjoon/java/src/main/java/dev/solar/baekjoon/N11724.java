package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11724 {
    private static int nodeCount, edgeCount;
    private static List<Integer>[] nodeList; // node의 갯수가 많아서 인접행렬로 만들 수 없다.
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        nodeList = new LinkedList[nodeCount + 1];
        isVisited = new boolean[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            nodeList[i] = new LinkedList();
        }

        // 간선 정보 입력
        for (int i = 1; i < edgeCount + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            nodeList[node1].add(node2);
            nodeList[node2].add(node1);
        }

        int count = 0;
        for (int i = 1; i < nodeCount + 1; i++) {
            if (!isVisited[i]) {
                count++;
                bfs(i); //1번 노드부터 탐색 시작
            }
        }
        System.out.println(count);
    }

    private static void bfs(int currentNode) {
        Queue<Integer> queue = new LinkedList<>();

        // 주의) 여기서 방문 표시를 해버리면 해당 노드의 인접 노드를 큐에 넣지 못함
        queue.offer(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (!isVisited[currentNode]) {
                isVisited[currentNode] = true;
                queue.addAll(nodeList[currentNode]); //현재 노드와 연결된 노드를 다음 방문 대기로 모두 넣음
            }
        }
    }
}
