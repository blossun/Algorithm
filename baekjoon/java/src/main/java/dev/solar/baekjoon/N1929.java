package dev.solar.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N1929 {
    public static boolean[] primeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());

        primeNumbers = new boolean[endNum + 1];

        // (1을 제회한) 모든 수가 소수라는 가정
        // boolean default value : false 이므로 반대로 소수이면 false가 남도록 구현
        primeNumbers[1] = true; // 1은 소수가 아님
        for (int i = 2; i < primeNumbers.length; i++) {
//            if (!isPrime(i)) { //이 과정이 없어야 시간초과 나지 않음
//                continue;
//            }
            for (int j = 2; i * j < primeNumbers.length; j++) { // 소수라면 소수의 배수값을 모두 true로 변경
                primeNumbers[i * j] = true;
            }
        }

        //  출력
        for (int i = startNum; i <= endNum; i++) {
            if (!primeNumbers[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
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
