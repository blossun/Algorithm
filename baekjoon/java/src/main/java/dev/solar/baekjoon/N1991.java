package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1991 {
    static int[] lc;
    static int[] rc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lc = new int[N + 1];
        rc = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] node = br.readLine().split(" ");
            int cur = node[0].charAt(0) - 'A' + 1;
            char l = node[1].charAt(0);
            char r = node[2].charAt(0);
            if (l != '.') {
                lc[cur] = l - 'A' + 1;
            }
            if (r != '.') {
                rc[cur] = r - 'A' + 1;
            }
        }

        preOrder(1);
        System.out.println();

        inOrder(1);
        System.out.println();

        postOrder(1);
        System.out.println();
    }

    private static void postOrder(final int cur) {
        if (lc[cur] != 0) postOrder(lc[cur]);
        if (rc[cur] != 0) postOrder(rc[cur]);
        System.out.print(Character.toChars(cur + 'A' - 1));
    }

    private static void inOrder(final int cur) {
        if(lc[cur] != 0) inOrder(lc[cur]);
        System.out.print(Character.toChars(cur + 'A' - 1));
        if(rc[cur] != 0) inOrder(rc[cur]);
    }

    private static void preOrder(final int cur) {
        System.out.print(Character.toChars(cur + 'A' - 1));
        if (lc[cur] != 0) preOrder(lc[cur]);
        if (rc[cur] != 0) preOrder(rc[cur]);
    }
}
