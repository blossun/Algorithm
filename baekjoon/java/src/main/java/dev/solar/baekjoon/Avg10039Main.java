package dev.solar.baekjoon;

import java.io.*;

public class Avg10039Main {
    public static void main(String[] args) throws IOException {
        Avg avg = new Avg();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[5];
        int result;

        for (int i = 0; i < 5; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        result = avg.solv(scores);
        System.out.println(result);
        br.close(); //닫아줘야함
    }
}

class Avg {
    int solv(int[] scores) {
        int sum = 0;

        for (int score : scores) {
            if (score < 40)
                score = 40;
            sum += score;
        }
        return sum / scores.length;
    }
}
