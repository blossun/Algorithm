package dev.solar.baekjoon;

import java.io.*;

public class Star10996Main {

    public static void main(String[] args) throws IOException {
        Star10996Solv star10996Solv = new Star10996Solv();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star10996Solv.star10996solv(Integer.parseInt(br.readLine()));
        br.close();
    }
}

class Star10996Solv {
    void star10996solv(int count) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < count; i++) {
            for (int j = 1; j <= count; j++) {
                if (j % 2 == 1) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
            for (int j = 1; j <= count; j++) {
                if (j % 2 == 1) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();;
        bw.close();
    }
}

/*
한 횟수차가 1열과 2열로 구성
입력받은 카운트 만큼 (1열+2열) * n 행 출력
1열 : 홀수 번째 출력
2열 : 짝수 번째 출력
 */
