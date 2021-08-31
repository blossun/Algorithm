package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 방향 연결 그래프 채우기
        LinkedList<Integer>[] students = new LinkedList[studentNum + 1];
        for (int i = 1; i <= studentNum; i++) {
            students[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            students[pre].add(post);
        }

        // 1. 모든 간선을 읽으면서 Indegree 테이블을 채운다.
        int[] indegree = new int[studentNum + 1];
        for (int i = 1; i <= studentNum; i++) {
            LinkedList<Integer> student = students[i];
            for (Integer prev : student) {
                indegree[prev]++;
            }
        }

        // 2. Indegree가 0인 정점을 모두 큐에 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= studentNum; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. 큐의 front에 있는 정점을 가져와 위상 정렬 결과에 추가 (큐가 빌 때까지 반복)
        int[] result = new int[studentNum + 1]; //위상 정렬 결과
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[idx++] = cur;
            // 4. 해당 정점으로부터 연결된 모든 정점의 의  Indegree 값을 1 감소
            for (int i = 0; i < students[cur].size(); i++) {
                int next = students[cur].get(i);
                indegree[next]--;
                if (indegree[next] == 0) { //    Indegree가 0이 되었다면 큐에 추가
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
