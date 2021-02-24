package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // D[i] : 합 i를 나타내는 방법의 수
            // sum[i] : D[1] ~ D[i]번째 까지 합계
            // D[i] = D[i - 3] + D[i -2] + D[i -1]
            int[] result = new int[11]; //n이 11보다 작다고 하였으므로 미리 11개로 셋팅. (n+1)만큼으로 만들면 n이 1일때 3번 인덱스 접근 에러가 난다.
            result[1] = 1; //첫 항 초기화
            result[2] = 2;
            result[3] = 4;

            for (int i = 4; i < n + 1; i++) {
                result[i] = result[i - 3] + result[i - 2] + result[i - 1];
            }
            sb.append(result[n]).append('\n');
        }
        System.out.println(sb);
    }
}
