package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break ;
            }
            System.out.println(countPrime(n));
        }

        br.close();
    }

    public static int countPrime(int n) {
        boolean[] primeNumbers = new boolean[2 * n + 1];
        primeNumbers[1] = true; // 1은 소수가 아님
        for (int i = 2; i < primeNumbers.length; i++) {
            for (int j = 2; i * j < primeNumbers.length; j++) { // 소수라면 소수의 배수값을 모두 true로 변경
                primeNumbers[i * j] = true;
            }
        }

        int count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (!primeNumbers[i]) {
                count++;
            }
        }

        return count;
    }

}
