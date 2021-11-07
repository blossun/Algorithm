package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] visited = new int[100002];
        int st = 0;
        int max = 0;
        visited[arr[st]]++;

        for (int en = 1; en < N; en++) {
            int num = arr[en];
            if (visited[num] >= K) {
                while (true) {
                    if (arr[st] == num) {
                        visited[arr[st]]--;
                        st++;
                        break;
                    }
                    visited[arr[st]]--;
                    st++;
                }
            }
            visited[num]++;
//            System.out.println("st : " + st + " , en : " + en);
            max = Math.max(en - st + 1, max);
        }

        System.out.println(max);
    }
}
