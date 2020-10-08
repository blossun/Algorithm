package dev.solar.baekjoon;

import java.io.*;
import java.util.Arrays;

public class N1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberOfPrime = 0;
        for (int number : numbers) {
            if (isPrime(number)) {
                numberOfPrime++;
            }
        }

        System.out.println(numberOfPrime);

        br.close();
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
