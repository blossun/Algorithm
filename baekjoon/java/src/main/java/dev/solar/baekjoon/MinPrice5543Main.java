package dev.solar.baekjoon;

import java.io.*;
import java.util.Arrays;

public class MinPrice5543Main {
    public static void main(String[] args) throws IOException {
        Solv5543 solv5543 = new Solv5543();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] bugers = new int[3];
        int[] beverages = new int[2];

        for (int i = 0; i < 3; i++) {
            bugers[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            beverages[i] = Integer.parseInt(br.readLine());
        }

        bw.write(solv5543.solv(bugers, beverages) + " "); //문자열로 변환해줘야 함. 속도 20ms 정도 줄었음 ㅠ
        bw.flush();
        br.close();
        bw.close();
    }
}

class Solv5543 {
    int solv(int[] bugers, int[] beverages) {
        int minBugerPrice = Arrays.stream(bugers).min().getAsInt();
        int minBeveragePrice = Arrays.stream(beverages).min().getAsInt();
        return (minBugerPrice + minBeveragePrice - 50);
    }
}
