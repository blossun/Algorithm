package dev.solar.baekjoon;

import java.io.*;

public class Star2447Main {

    public static void main(String[] args) throws IOException {
        Star2447Solv star2447Solv = new Star2447Solv();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star2447Solv.start2447Solv(Integer.parseInt(br.readLine()));
    }
}

class Star2447Solv {
    void start2447Solv(int n) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 1 && j == 1) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
//bw가 아니라 string으로 반환하는 별도의 메서드로 추출해야할듯???
// n=3 인 경우
/*
"***
"* *
"***
*/
/*
1. n만큼 출력
2. (1, 1) 이면 출력 안 함
    아니면 출력
3. n만큼 출력
 */

/* n=6 인 경우
*********
* ** ** *
*********
***   ***
* *   * *
***   ***
*********
* ** ** *
*********
*/
/*
1. n만큼 출력
2. (1, 1) 이면 출력 안 함
    아니면 출력
3. n만큼 출력
n/3 만큼 다시 재호출해서 출력
 */
