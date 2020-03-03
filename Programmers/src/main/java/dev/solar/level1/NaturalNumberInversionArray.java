package dev.solar.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class NaturalNumberInversionArray {
    public int[] solution(long n) {
        String[] tempStr = String.valueOf(n).split("");
        int size = tempStr.length;
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = Integer.parseInt(tempStr[size-(i+1)]);
        }
        return answer;

        // Solution2
/*
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;

        while(n>0) {
//            System.out.println("n%10 : " + n%10 + ", n/10 : " + n/10);
            answer[cnt]=(int)(n%10); //나머지
            n/=10; //몫
            System.out.println(n);
            cnt++;
        }
        return answer;
*/
    }
}
