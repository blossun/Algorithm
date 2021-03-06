package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N15651 {
    static int N, size;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[size];
        sequence(0);

        System.out.println(sb);
    }

    private static void sequence(int depth) { // 현재 k번째까지 선택
        if (depth == size) { // 깊이가 최대 깊이일경우 더이상 탐색할 자식노드는 없으므로 return
            for (int i = 0; i < size; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = 1; i <= N; i++) { // 깊이를 1씩 증가시키면서 DFS를 재귀호출
            arr[depth] = i;
            sequence(depth + 1);
        }

    }
}
