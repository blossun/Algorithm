package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N11780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int vertext = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        int[][] D = new int[vertext + 1][vertext + 1];
        int[][] nxt = new int[vertext + 1][vertext + 1];
        int INF = 100_000_001;
        // 최단거리 배열 초기화
        for (int i = 0; i < D.length; i++) {
            Arrays.fill(D[i], INF);
            D[i][i] = 0; //자기 자신으로 가는 경로는 0
        }

        // 간선 1개로 건널 수 있는 곳 초기화 "중간에 다른 정점을 거치지 않았을 때 최단 거리"
        for (int i = 0; i < edge; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            D[from][to] = Math.min(D[from][to], cost);
            nxt[from][to] = to;
        }

        //floyd 알고리즘
        for (int mid = 0; mid <= vertext; mid++) {
            for (int start = 1; start <= vertext; start++) { //start -> mid
                for (int end = 1; end <= vertext; end++) { // mid -> end
                    int cost = D[start][mid] + D[mid][end];
                    if (cost < D[start][end]) {
                        D[start][end] = cost;
                        nxt[start][end] = nxt[start][mid];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int start = 1; start <= vertext; start++) {
            for (int end = 1; end <= vertext; end++) {
                if (D[start][end] == INF) {
                    sb.append("0").append(" ");
                } else {
                    sb.append(D[start][end]).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int start = 1; start <= vertext; start++) {
            for (int end = 1; end <= vertext; end++) {
                if (D[start][end] == 0 || D[start][end] == INF) {//자기자신이거나 길이 없는 경우
                    sb.append("0").append("\n");
                    continue;
                }
                sb.append(getCourse(nxt, start, end)).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    private static String getCourse(final int[][] nxt, int start, int end) {
        // start -> end 로 가는 최단 경로를 계산
        List<Integer> path = new LinkedList<>();
        int cur = start;
        while (cur != end) {
            path.add(cur);
            cur = nxt[cur][end];
        }
        path.add(end);

        // path를 문자열로 만들어서 반환
        StringBuilder sb = new StringBuilder();
        sb.append(path.size()).append(" ");
        for (Integer p : path) {
            sb.append(p).append(" ");
        }
        return sb.toString();
    }
}
