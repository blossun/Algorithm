package dev.solar.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N13549 {
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new int[2000002];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();

        //시작위치
        q.add(N);
        visited[N] = 0;

        while (q.peek() != K) {
            int cur = q.poll();
            for (int next : new int[]{cur * 2, cur - 1, cur + 1}) {
                if (next < 0 || next >= 2000002) continue;
                int currentDistinct;
                if (next == cur * 2) {
                    currentDistinct = visited[cur];
                } else {
                    currentDistinct = visited[cur] + 1;
                }
                if (visited[next] != -1 && visited[next] <= currentDistinct) continue;
                visited[next] = currentDistinct;
                q.add(next);
            }
        }

        System.out.println(visited[K]);
    }
}
