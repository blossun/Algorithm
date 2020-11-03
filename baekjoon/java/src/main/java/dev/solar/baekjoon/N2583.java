package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2583 {
    static int[][] board;
    static int[][] draw;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int X;
    static int Y;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[X][Y]; //행(Y)가 앞 인덱스여야 함!!
        draw = new int[X][Y];

        // 직사각형 그리기
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int xWidth = x1; xWidth < x2; xWidth++) {
                for (int yWidth = y1; yWidth < y2; yWidth++) {
                    board[xWidth][yWidth] = 1;
                }
            }
        }

//        for (int y = 0; y < Y; y++) {
//            for (int x = 0; x < X; x++) {
//                System.out.print(board[x][y]);
//            }
//            System.out.println();
//        }

        // 영역 구하기
        Queue<Point> q = new LinkedList<>();
        int count = 0; //영역의 수
        int width;
        List<Integer> widths = new ArrayList<>(); //영역의 넓이

        for (int xi = 0; xi < X; xi++) {
            for (int yi = 0; yi < Y; yi++) {
                if (board[xi][yi] != 0 || draw[xi][yi] > 0) continue; //board에서 0인 부분을 체크해야함
                count++; //새로운 영역 갯수 증가
                width = 1; //영역의 넓이는 1부터 시작
                q.add(new Point(xi, yi));

                while(!q.isEmpty()) {
                    Point cur = q.poll();
                    draw[cur.x][cur.y] = 1;
                    for (int dir = 0; dir < 4; dir++) {
                        int x = cur.x + dx[dir];
                        int y = cur.y + dy[dir];
                        if (x < 0 || x >= X || y < 0 || y >= Y) continue;
                        if (board[x][y] != 0 || draw[x][y] > 0) continue;
                        q.add(new Point(x, y));
                        draw[x][y] = draw[cur.x][cur.y] + 1;
                        width++;
                    }
                }
                widths.add(width);
            }
        }

//        for (int y = 0; y < Y; y++) {
//            for (int x = 0; x < X; x++) {
//                System.out.print(draw[x][y]);
//            }
//            System.out.println();
//        }

        System.out.println(count);
        Collections.sort(widths);
        for (Integer w : widths) {
            System.out.printf("%d ", w);
        }
    }
}
/*
오른쪽 위 꼭짓접 좌표 -> board(x-1, y-1)까지
 */
