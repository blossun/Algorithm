package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int vertex = Integer.parseInt(br.readLine());
        int Edge = Integer.parseInt(br.readLine());
        int[][] arr = new int[vertex][vertex];
        int INF = 100_000_001; //최댓값 +1
        // 모든 경우의 수를 INF로 초기화하고 자기자신으로 가는 경로는 0으로 갱신
        for (int i = 0; i < vertex; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        // 간선 1개로 건널 수 있는 곳 초기화 "중간에 다른 정점을 거치지 않았을 때 최단 거리"
        for (int i = 0; i < Edge; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken()) - 1;
            int to = Integer.parseInt(token.nextToken()) - 1;
            int cost = Integer.parseInt(token.nextToken()) - 1;
            arr[from][to] = Math.min(arr[from][to], cost);
        }

        //floyd 알고리즘
        for (int mid = 0; mid < vertex; mid++) { // (a -> b)경로를 1 ~ V  노드를 거쳐서 갈 때의 최단 거리 갱신
            for (int start = 0; start < vertex; start++) { // (start -> mid)
                for (int end = 0; end < vertex; end++) { // (mid -> end)
                    int newCost = arr[start][mid] + arr[mid][end];
                    arr[start][end] = Math.min(arr[start][end], newCost);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            Arrays.stream(ints).forEach(n -> {
                if (n == INF) n = 0;
                sb.append(n).append(" ");
            });
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
