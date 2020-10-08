package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());
        int sum = 0;
        int minPrime = -1;

        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                if (minPrime == -1) {
                    minPrime = i;
                }
                sum += i;
            }
        }

        if (minPrime == -1) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(minPrime);
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1 || number < 0) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
