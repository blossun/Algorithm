package dev.solar.baekjoon;

import java.io.*;

public class Star2446Main {

    public static void main(String[] args) throws IOException {
        Star2446Solv star2446Solv = new Star2446Solv();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star2446Solv.star2446solv(Integer.parseInt(br.readLine()));
        br.close();
    }
}

class Star2446Solv {
    void star2446solv(int count) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) { //공백찍기
//                bw.write(" ");
                System.out.print(" ");
            }
            x = (count - i) * 2 - 1;
            for (int j = 0; j < x; j++) { //별찍기
//                bw.write("*");
                System.out.print("*");
            }
//            bw.write("\n");
            System.out.println();
        }
        for (int i = 1; i < count; i++) {
            x = count - (i + 1);
            for (int j = 0; j < x; j++) { //공백찍기
                System.out.print(" ");
            }
            x = (i + 1) * 2 - 1;
            for (int j = 0; j < x; j++) { //별찍기
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
