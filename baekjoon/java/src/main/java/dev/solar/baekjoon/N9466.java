package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9466 {
    public static int[] board;
    public static int[] disit;
    public static boolean[] visit;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            board = new int[N + 2]; //index가 1부터 시작
            disit = new int[N + 2];
            visit = new boolean[N + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            count = 0; //팀에 속하지 못한 학생
            Arrays.fill(disit, -1);

            // 시작 위치가 여러 군데
            for (int i = 1; i <= N; i++) {
                if (disit[i] != -1) continue; //방문한 곳이면 skip
                checkMember(i);
            }

//            System.out.println("----------------------");
//            for (int d : disit) {
//                System.out.print(d);
//                System.out.print(" ");
//            }
//            System.out.println("----------------------");

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    private static void checkMember(int startIndex) {
//        System.out.println("startIndex : " + startIndex);
        Arrays.fill(visit, false); //이번 턴에서 방문했는지 여부를 체크
        Queue<Integer> q = new LinkedList<>();
        disit[startIndex] = 0;
        visit[startIndex] = true;
        q.add(startIndex);

        while (!q.isEmpty()) {
            int cur = q.poll();

            int next = board[cur];
            if (!visit[next]) {
                if (disit[next] != -1) { //이번 턴에서 방문 한적없는데 -1이면 이미 다른 턴에서 다녀간 것임
                    count += disit[cur] + 1;
                    return;
                }
                visit[next] = true;
                disit[next] = disit[cur] + 1;
                q.add(next);
                continue;
            }
            if (visit[next]) { //이미 방문한 곳이면서,  내가 지목한 사람이 이미 다른 사람을 선택한 경우임
//                System.out.println("next : " + next + ", disit[next] : " + disit[next]);
                count += disit[next];
                return;
            }
        }

    }
}
