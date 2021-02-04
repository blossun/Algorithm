package dev.solar.baekjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5014 {
    public static int[] board = new int[2000002]; //이동거리 : F 최댓값 + U 최댓값
    public static int F; //전체 층수
    public static int S; //시작 위치
    public static int G; //goal 목적지 층
    public static int U; //Up
    public static int D; //Down

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        Queue<Integer> q = new LinkedList<>(); //다음 이동할 위치
        Arrays.fill(board, -1); // 이동거리 -1로 초기화 -1은 방문하지 않은 곳

        // 시작 지점 위치 지정
        board[S] = 0; //처음 위치
        q.add(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 목적지에 도달하면 종료
            if (cur == G) {
                System.out.println(board[cur]); //이동횟수가 담겨있다.
                return ;
            }

            for (int next : new int[]{cur + U, cur - D} ) { // 다음 이동 위치를 큐에 담아줌. Up, Down 지점
                if (next < 1 || next > F) continue; // 범위를 벗어나면 skip
                if (board[next] != -1) continue; //방문한 곳이면 skip
                board[next] = board[cur] + 1;
                q.add(next);
            }
        }
//        for (int i = 0; i < F; i++) {
//            System.out.print(board[i]);
//            System.out.print(" ");
//        }

        // 목적지에 도달하지 못하고 나오면 도착 불가능
        System.out.println("use the stairs");
    }
}
