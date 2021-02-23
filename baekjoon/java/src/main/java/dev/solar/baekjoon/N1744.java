package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0;
        boolean isAppeared = false;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 0) {
                positive.add(number);
            } else if (number < 0) {
                negative.add(number);
            } else {
                isAppeared = true;
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);
        Integer[] positiveArray = positive.toArray(new Integer[positive.size()]);
        Integer[] negativeArray = negative.toArray(new Integer[negative.size()]);
        for (int i = 0; i < positiveArray.length; i++) {
            if (i + 1 == positiveArray.length) { //하나 남은 경우
                total += positiveArray[i];
                continue;
            }
            if (positiveArray[i + 1] == 1) { // 1과 join되는 경우에는 곱하지말고 더해야함
                total += positiveArray[i] + positiveArray[i + 1];
                i++;
                continue;
            }
            total += positiveArray[i] * positiveArray[i + 1];
            i++;
        }
        for (int i = 0; i < negativeArray.length; i++) {
            if (i + 1 == negativeArray.length) { //하나 남은 경우
                total += isAppeared ? 0 : negativeArray[i];
                continue;
            }
            //하나 남은 경우가 아니면
            total += negativeArray[i] * negativeArray[i + 1];
            i++;
        }
        System.out.println(total);
    }
}
