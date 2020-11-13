package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class N2448 {
    static int size;
    static char[][] board;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = sc.nextInt();
        board = new char[size][size * 2];

        // 배열을 ' ' 로 초기화 //나중에 '*' 자리만 채워줌
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }
//
//        for (int x = 0; x < N; x++) {
//            for (int y = 0; y < N * 2; y++) {
//                System.out.print(board[x][y]);
//            }
//            System.out.println();
//        }

        draw(0, size - 1, size);

        //출력
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size * 2; y++) {
                bw.write(board[x][y]);
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    private static void draw(int x, int y, int size) {
//        System.out.println("x, y : " + x + ", " + y + ", size : " + size);
        // Base Condition
        if (size == 3) { //k=0 일 때, 최소 모양
            board[x][y] = '*';
            board[x + 1][y - 1] = board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = board[x + 2][y - 1] = board[x + 2][y] = board[x + 2][y + 1] = board[x + 2][y + 2] = '*';
            return;
        }

        // 삼각형 3개 그리기
        draw(x, y, size / 2); //첫번째 삼각형의 꼭지점과 size
        draw(x + size / 2, y - size / 2, size / 2); //두번째 삼각형의 꼭지점과 size
        draw(x + size / 2, y + size / 2, size / 2); //세번째 삼각형의 꼭지점과 size
    }
}
