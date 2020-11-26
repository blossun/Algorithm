package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static dev.solar.baekjoon.N2583.draw;

public class N15683 {
    //BFS
    static int[][] board; //cctv, 벽을 입력받고, 이후 감시영역을 추가 - 0: 사각지대, !0 : 사각지대 외
    static boolean[][] visit; //사각지대 영역을 탐색
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int X;
    static int Y;

    //백트래킹
    static int N = 4;
    static int M;
//    static List<Point> cctvQ = new ArrayList<>();
    static int[] cctvArr; //cctv 방향별로 나올 수 있는 순열 조합
    static List<Integer> blindSpotAreas = new ArrayList<>(); //상황별 사각지대 영역

    // 순서대로, cctv를 4방향으로 돌렸을 때 cctv의 감시방향
    // 백트래킹으로 각 cctv별 동서남북 뱡향들의 순열을 알아냄
    // 자연수 N(0~3, 사방) 수에서 M(cctv 갯수)개를 고른 수열
    static int[][] cctv1 = {{0}, {1}, {2}, {3}};
    static int[][] cctv2 = {{0, 1}, {2, 3}, {0, 1}, {2, 3}};
    static int[][] cctv3 = {{0, 3}, {0, 2}, {1, 2}, {1, 3}};
    static int[][] cctv4 = {{0, 1, 3}, {0, 1, 2}, {0, 2, 3}, {1, 2, 3}};
    static int[][] cctv5 = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
    static List<Cctv> cctvs = new ArrayList<>();

    static class Cctv {
        int id;
        Point location;
        int[][] cctvArea;

        public Cctv(int id, Point location, int[][] cctvArea) {
            this.id = id;
            this.location = location;
            this.cctvArea = cctvArea;
        }
    }

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        board = new int[X][Y];
        visit = new boolean[X][Y];

        // cctv, 벽 입력 받기
        for (int x = 0; x < X; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < Y; y++) {
                int p = Integer.parseInt(st.nextToken());
                board[x][y] = p;
                if (isCCTV(p)) { //cctv 인 경우 cctvs 리스트에 저장
                    storeCCTV(p, new Point(x, y));
                }
            }
        }
        //cctv 객수 = M개를 뽑아내는 수열
        M = cctvs.size();
        cctvArr = new int[M];
        System.out.println("cctv 갯수 (M) : " + M);
        sequence(0);
        // board 출력
//        for (int x = 0; x < X; x++) {
//            for (int y = 0; y < Y; y++) {
//                System.out.print(board[x][y]);
//            }
//            System.out.println();
//        }


        // cctv 감시 영역으로 나올 수 있는 경우의 수 - 순열 구하기

//        cctvs.add(new Cctv(1, ccvt1));
//        cctvs.add(new Cctv(2, ccvt2));
//        cctvs.add(new Cctv(3, ccvt3));
//        cctvs.add(new Cctv(4, ccvt4));
//        cctvs.add(new Cctv(5, ccvt5));

        
    }

    private static void storeCCTV(int num, Point location) {
        switch (num) {
            case 1 :
                cctvs.add(new Cctv(1, location, cctv1));
                break;
            case 2 :
                cctvs.add(new Cctv(2, location, cctv2));
                break;
            case 3 :
                cctvs.add(new Cctv(3, location, cctv3));
                break;
            case 4 :
                cctvs.add(new Cctv(4, location, cctv4));
                break;
            case 5 :
                cctvs.add(new Cctv(5, location, cctv5));
                break;
        }
    }

    private static void sequence(int k) {
        if (k == M) { //M개의 cctv 모두 방향이 정해졌다면
//            blindSpotAreas.add(getBlindArea(cctvArr)); //해당 상황에서 사각지대 영역을 구해서 저장
            for (int i = 0; i < cctvArr.length; i++) {
                System.out.print(cctvArr[i]);
            }
            System.out.println();
            getBlindArea(cctvArr);
            return ;
        }

        for (int i = 0; i < N; i++) {
            cctvArr[k] = i;
            sequence(k + 1);
        }
    }

    private static void getBlindArea(int[] cctvArr) { //cctv 방향이 정해진 배열을 넘겨받음
        // 감시 영역 채우기
        int[][] board2 = new int[X][Y];
        //            board2 = board.clone(); //제대로된 복사가 이루어지지 않음
        // 2차원 배열의 깊은 복사!!!
        for (int x = 0; x < board2.length; x++) {
            System.arraycopy(board[x], 0, board2[x], 0, board.length);
        }

        int cctvCount = cctvArr.length;
        for (int i = 0; i < cctvCount; i++) { //각 cctv 별로 감시 영역 그리기
            Cctv cctv = cctvs.get(i);

            board2 = draw(board2, cctv, cctvArr[i]); //해당 cctv랑, cctv 방향정보를 넘김

        }
        // 감시 영역이 채워진 board에서 사각지대 구하기

        // board2가 잘 그려졌는지 확인
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                System.out.print(board2[x][y] + " ");
            }
            System.out.println();
        }

//        return null;
    }

    private static int[][] draw(int[][] board2, Cctv cctv, int dir) {
        int[] ints = cctv.cctvArea[dir]; //바라보는 방향이 담겨있음
        int curX = cctv.location.x;
        int curY = cctv.location.y;
        System.out.println("CCTV : " + cctv.id +", curX : " + curX + ", curY : " + curY);

        for (int i = 0; i < ints.length; i++) { //각 바라보는 방향별로 감시영역 그리기
            while (true) {
                int x = curX + dx[ints[i]];
                int y = curY + dy[ints[i]];
                if (x < 0 || x >= X || y < 0 || y >= Y)
                    break; //보드를 벗어나면 그리기 종료
                if (board2[x][y] == 6) //cctv를 만난경우, 해당방향 그리기 종료
                    break;
                if (board2[x][y] == 0) {
                    board2[x][y] = 7; //감시영역 표시
                }
                curX = x;
                curY = y;
            }
        }
        return board2;
    }

    private static boolean isCCTV(int p) {
        return (1 <= p && p <= 5);
    }
}
