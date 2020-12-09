package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 주어지는 숫자는 중복이 없고!, 절댓값이 1000보다 작거나 같으므로 -1000 ~ 10000 을 담을 배열을 하나 생성
        boolean[] input = new boolean[20002]; //0도 포함해야함. 20001 보다크게 잡아줌.
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            input[num + 1000] = true; //입력값에 + 1000해서 true로 표시 (음수때문에)
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i]) {
                sb.append(i - 1000).append('\n');
            }
        }
        System.out.println(sb);
    }
}
