package dev.solar.baekjoon;

import java.io.*;
import java.util.*;

public class N15666 {
    private static int N, M;
    private static int[] nums;
    private static int[] arr;
    private static Set<String> result = new LinkedHashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        bt(0, 0);
        Iterator<String> it = result.iterator();
        while (it.hasNext()) {
            bw.write(it.next());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bt(int start, int k) {
        if (k == M) {
            for (int i : arr) {
               sb.append(i).append(' ');
            }
            sb.append('\n');
            result.add(sb.toString());
            sb.delete(0, sb.length());
            return ;
        }

        for (int i = start; i < N; i++) {
            arr[k] = nums[i];
            bt(i, k + 1);
        }

    }
}
