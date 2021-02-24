package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1260 {
    private static int[][] graph;
    private static boolean[] visit;
    private static int n, m, v;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //노드
        m = Integer.parseInt(st.nextToken()); //간선
        v = Integer.parseInt(st.nextToken()); //시작 노드

        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        while (m-- != 0) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph[src][dest] = graph[dest][src] = 1;
        }

        dfs(v);
        System.out.println(sb);
        
        //초기화
        Arrays.fill(visit, false);
        sb.delete(0, sb.length());

        bfs(v);
        System.out.println(sb);

    }

    private static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i < n + 1; i++) {
            if (graph[v][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        visit[v] = true;
        queue.offer(v);
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[cur][i] == 1 && !visit[i]) { //cur - i 에 간선이 있고, 방문하지 않은 곳이라면
                    visit[i] = true; //방문했다는 표시를 남기고
                    queue.offer(i); //다음 방문지점으로 대기
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
