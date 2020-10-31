package dev.solar.baekjoon;

import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1926 {
    static int[][] board; // 칸
    static boolean[][] visit; // 방문 여부 표시 : 1 - 방문함, 0 - 방문 안 함
    static int[] dx = {1, 0, -1, 0}; //상하좌우 네 방향
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];
        int maxWidth = 0; //그림 최댓값
        int count = 0; //그림의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); //한 줄씩 받아줘야 함
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { //(i, j)를 시작지점으로
                //해당 좌표가 그림부분이 아니거나(0) 이미 방문한 곳(visit[i][j] == ture_이면 넘어감
                if (board[i][j] == 0 || visit[i][j]) continue;
                // (i, j)는 새로운 그림에 속해있는 시작점
                count++; // 그림의 수 1 증가
                Queue<Point> q = new LinkedList<>(); //큐에 (x,y)좌표 pair 타입 데이터 저장
                // (i, j)를 BFS의 시작점으로 출발하기 위한 준비
                // 방문 표시를 큐에 넣을 때 해줌!!!!
                // (뺄 때 표시 no -> 같은 칸이 큐에 여러 번 들어가서 시간 초과나 메모리 초과 발생할 수 있음)
                visit[i][j] = true; // 시작점을 방문했다고 표시
                q.add(new Point(i, j));
                int area = 0; //현재 그림의 넒이
                while (!q.isEmpty()) {
                    area++; //큐에 들어있는 원소를 하나 뺄 때 마다 넓이를 1 증가시킴
                    Point cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) { //현재 좌표의 상하좌우 칸을 살펴봄
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 밖일 경우 넘어감
                        if (visit[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우
                        visit[nx][ny] = true; //(nx, ny)를 방문했다고 명시
                        q.add(new Point(nx, ny));
                    }
                }
                maxWidth = Math.max(maxWidth, area); // area가 mx보다 클 경우 mx에 area를 대입.
            }
        }
        System.out.println(count);
        System.out.println(maxWidth);
    }
}

/*
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
=> board 크기를 이보다 크게 잡아줌
 */
