package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(arr[0][1]); //첫번째 강의가 끝나는 시간
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= arr[i][0]) { //이미 존재하는 강의실에 들어갈 수 있는 경우
                queue.poll();
                queue.offer(arr[i][1]);
            } else { //들어갈 수 있는 강의실이 없는 경우
                queue.offer(arr[i][1]);
            }
        }
        System.out.println(queue.size());

    }

}
