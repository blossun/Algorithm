package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15655 {
    static int N, M;
    static int[] numbs; //수열 대상이 되는 숫자들
    static int[] arr; //뽑힌 수열을 담을 배열
    static boolean[] visit; //방문 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbs = new int[N];
        visit = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbs);

        sequence(0, 0);
        System.out.println(sb);
        br.close();
    }

    private static void sequence(int start, int k) {
        if (k == M) { //M개가 뽑힌 경우 - 출력 후 종료
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                arr[k] = numbs[i];
                visit[i] = true;
                sequence(i + 1, k + 1); // start + 1이 아니라 i + 1 값을 넘기는 것임
                visit[i] = false;
            }
        }
    }
}
