package dev.solar.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N5904 {
    static int N;
    static List<Character> mooStr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mooStr = new ArrayList<>();
        N = sc.nextInt();
        moo(N);//수열을 만들기만?
        System.out.println(mooStr.get(N - 1));
        System.out.println(mooStr.toString());
    }

    private static void moo(int n) {
        if (mooStr.size() >= N) //구하려는 N번쨰 이후 값은 필요 없음
        {
            System.out.println("size : " + mooStr.size());
            return;
        }

        if (n == 0) {
            mooStr.add('m');
            mooStr.add('o');
            mooStr.add('o');
            return;
        }

        moo(n - 1);
        mooStr.add('m');
        for (int i = 0; i < n + 2; i++) {
            if (mooStr.size() >= N) //구하려는 N번쨰 이후 값은 필요 없음
                return;
            mooStr.add('o');
        }
        moo(n - 1);
    }
}
