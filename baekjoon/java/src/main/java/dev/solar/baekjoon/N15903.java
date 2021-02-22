package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        while (--m >= 0) {
            // 2 <= n <= 1,000
            long x = queue.remove();
            long y = queue.remove();
            queue.add(x + y);
            queue.add(x + y);
        }
        System.out.println(queue.stream().reduce(0L, (a, b) -> a + b));
    }
}
