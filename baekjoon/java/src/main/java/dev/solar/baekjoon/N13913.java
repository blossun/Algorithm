package dev.solar.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수빈이 위치
        int K = sc.nextInt(); //동생 위치

        int[] disit = new int[200002];
        int[] prev = new int[200002];
        Arrays.fill(disit, -1);
        Arrays.fill(prev, -1);
        Queue<Integer> queue = new LinkedList<>();
        disit[N] = 0;
        prev[N] = 0;
        queue.add(N);

        while (queue.peek() != K) {
            int cur = queue.poll();
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue; //범위를 벗어나면 skip
                if (disit[next] != -1) continue; //이미 방문한 곳이면 skip
                disit[next] = disit[cur] + 1;
                prev[next] = cur;
                queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = disit[K];
        sb.append(count).append('\n');
        int[] result = new int[count + 1];
        result[count] = K;

        int cur = prev[K];
        for (int i = count - 1; i >= 0; i--) {
            result[i] = cur;
            cur = prev[cur];
        }

        for (int i : result) {
            sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }
}
