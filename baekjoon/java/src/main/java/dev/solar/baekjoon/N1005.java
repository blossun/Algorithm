package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            token = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());
            token = new StringTokenizer(br.readLine());
            int[] D = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                D[i] = Integer.parseInt(token.nextToken());
            }
            List<Integer>[] graph = new LinkedList[V + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            while (E-- > 0) {
                token = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                graph[from].add(to);
            }
            int W = Integer.parseInt(br.readLine());
            int result = shortest(V, D, graph, W);
            System.out.println(result);
        }

    }

    private static int shortest(final int v, final int[] d, final List<Integer>[] graph, final int w) {
        //     1. 모든 간선을 읽으면서 Indegree 테이블을 채운다.
        int[] indegree = new int[v + 1]; //i 앞에 선행되어야하는 노드 갯수
        for (int i = 1; i < graph.length; i++) {
            List<Integer> nodes = graph[i];
            for (Integer node : nodes) {
                indegree[node]++;
            }
        }
        //     2. Indegree가 0인 정점을 모두 큐에 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {//0은 제외해야함 주의
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //     3. 큐의 front에 있는 정점을 가져와 위상 정렬 결과에 추가 (큐가 빌 때까지 반복)
        int[] result = new int[v + 1]; //해당 건물을 짓기 시작하는 데 걸리는 최소시간
        result[0] = 0;
        while (!queue.isEmpty()) {
            //     4. 해당 정점으로부터 연결된 모든 정점의 Indegree 값을 1 감소
            //        Indegree가 0이 되었다면 큐에 추가
            Integer node = queue.poll();
            if (node == w) {
                break;
            }
            List<Integer> edges = graph[node];
            for (Integer edge : edges) {
                // 현재 node의 후행 node의 최소 건설시작시간을 갱신
                // 현재 node의 최초 건설시작시간 + node 짓는 시간
                result[edge] = Math.max(result[edge], result[node] + d[node]);
//                System.out.println("edge : " + edge + ", d[edge] : " + d[edge] + ", result[edge] : " + result[edge]);
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    queue.add(edge);
                }
            }
        }

        return result[w] + d[w]; //목표 건물을 짓기 시작하는 시간 + 짓는데 걸리는 시간
    }
}
