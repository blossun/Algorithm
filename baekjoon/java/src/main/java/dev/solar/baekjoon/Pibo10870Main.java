package dev.solar.baekjoon;

import java.io.*;

public class Pibo10870Main {

    public static void main(String[] args) throws IOException {
        Pibo10870sSolv pibo10870sSolv = new Pibo10870sSolv();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = pibo10870sSolv.pibo10870Solv(Integer.parseInt(br.readLine()));
        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

class Pibo10870sSolv {
    int pibo10870Solv(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return pibo10870Solv(n - 2) + pibo10870Solv(n - 1);
    }
}
