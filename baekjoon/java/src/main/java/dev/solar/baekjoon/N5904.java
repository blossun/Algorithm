package dev.solar.baekjoon;

import java.util.Scanner;

public class N5904 {
    static int N; //출력하고자 하는 인덱스
    static int[] MooLen = new int[100]; //Moo의 길이를 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        MooLen[0] = 3;
        for (int i = 1; i < 100; i++) {
            MooLen[i] = MooLen[i - 1] * 2 + (i + 3);
            if (MooLen[i] > 1e9) break;
        }

        System.out.println(moo(N));
    }

    private static char moo(int n) {
        if (n <= 3) { //baseCondition
            if (n == 1) return 'm';
            else return 'o';
        }

        int m = 1;
        while (n > MooLen[m]) //MooLen을 통해서 어느 S(M)에 속하는지 찾는다.
            m++;

        if (n <= MooLen[m] - MooLen[m - 1]) { //Moo..oo 구간에 속한 경우
            if (n - MooLen[m - 1] == 1) return 'm'; //첫번째만 'm' 출력
            else return 'o'; //이후에 'n'출력
        }

        return moo(n - MooLen[m - 1] - (m + 3)); //S(N-1)구간에 (앞,뒤) 존재하는 경우
    }
}
