package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star2523Main {

    public static void main(String[] args) throws IOException {
        Star2523Solv star2523Solv = new Star2523Solv();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star2523Solv.star2523solv(Integer.parseInt(br.readLine()));
        br.close();
    }
}

class Star2523Solv {
    void star2523solv(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = -1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
