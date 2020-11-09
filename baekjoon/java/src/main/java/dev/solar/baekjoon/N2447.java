package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        arr = new char[N][N];

        star(0, 0, N, false);
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                bw.write(arr[x][y]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    
    static void star(int x, int y, int N, boolean isBlank) {

        // 공백인 경우
        if (isBlank) {
            for (int i = x; i < x + N; i++) { //한 블록 사이즈 만큼 공백으로 채우기
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // Base Condition
        // 더 이상 쪼갤 수 없는 블록인 경우
        if (N == 1) {
            arr[x][y] = '*';
            return ;
        }

        /*
		   N=27 일 경우 한 블록의 사이즈는 9이고,
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size

		   count는 별 출력 누적을 의미
		 */
        int size = N / 3; //한 블록의 사이즈
        int count = 0;
        for (int i = x;  i < x + N; i += size) { //한 블록 단위로 돌림
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) // 공백 칸인 경우
                    star(i, j, size, true);
                else
                    star(i, j, size, false);
            }
        }
    }
}
