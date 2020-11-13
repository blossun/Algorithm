package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1182 {
    static int N, S, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        track(0, 0);
        // 공집합은 제외 -> {0, 0, .... , 0}
        // S 가 0으로 들어오는 경우에만 확인하면 된다.
        if (S == 0)
            count--;
        System.out.println(count);
    }

    private static void track(int curIdx, int sum) { //sum : 수열의 합
//        System.out.println("curIdx : " + curIdx + ", sum : " + sum);
        if (curIdx == N) { // N번 depth까지 내려갔다면
            if (sum == S) { //합이 S가 되는지 확인
                count++;
            }
            return ; //N번 depth이면 return해야함
        }

        // 현재 숫자를 부분 수열에 넣거나(더하거나) or 안넣거나(더하지 않거나) 둘 중 하나를 선택
        track(curIdx + 1, sum);
        track(curIdx + 1, sum + arr[curIdx]); //arr[curIdx + 1] 을 더하는 것이 아님
    }
}
