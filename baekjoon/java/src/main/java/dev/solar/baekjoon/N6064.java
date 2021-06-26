package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int M, N, x, y;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int result = solution(M, N, x, y);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solution(int m, int n, int x, int y) {
        x = (m == x) ? 0 : x;
        y = (n == y) ? 0 : y;
        for (int i = x; i < m * n; i += m) {
            if (i % n == y) {
                return i;
            }
        }
        return -1;
    }

    // Recursive method to return gcd of a and b
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
