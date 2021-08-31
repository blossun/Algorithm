package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int singerNum = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] orderList = new LinkedList[singerNum + 1];
        for (int i = 0; i < singerNum + 1; i++) {
            orderList[i] = new LinkedList<>();
        }

        // 방향 연결 그래프 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int post = Integer.parseInt(st.nextToken());
                orderList[pre].add(post);
                pre = post;
            }
        }

//         1. 모든 간선을 읽으면서 Indegree 테이블을 채운다.
        int[] indegree = new int[singerNum + 1];
        for (int i = 1; i < singerNum + 1; i++) { //0은 제외
            LinkedList<Integer> tree = orderList[i];
            for (Integer node : tree) {
                indegree[node]++;
            }
        }
//         2. Indegree가 0인 정점을 모두 큐에 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) { //0은 제외
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
//         3. 큐의 front에 있는 정점을 가져와 위상 정렬 결과에 추가 (큐가 빌 때까지 반복)
        int[] result = new int[singerNum];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[idx++] = cur;
//         4. 해당 정점으로부터 연결된 모든 정점의 Indegree 값을 1 감소
            for (int i = 0; i < orderList[cur].size(); i++) {
                int next = orderList[cur].get(i);
                indegree[next]--;
                if (indegree[next] == 0) { //Indegree가 0이 되었다면 큐에 추가
                    queue.offer(next);
                }
            }
        }

        // 순환하는 구간이 있다면 순서를 정하는 것이 불가능 하므로 0 출력
        for (int n : indegree) {
            if (n != 0) {
                System.out.println(0);
                return ;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
