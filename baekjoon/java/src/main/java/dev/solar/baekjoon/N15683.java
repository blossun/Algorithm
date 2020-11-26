package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N15683 {
    //BFS
    static int[][] board; //cctv, 벽을 입력받고, 이후 감시영역을 추가 - 0: 사각지대, !0 : 사각지대 외
    static int[][] board2; //bfs 돌리려고 전역으로 선언
    static int[][] visit; //사각지대 영역을 탐색
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int X;
    static int Y;

    //백트래킹
    static int N = 4;
    static int M;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        board = new int[X][Y];
        visit = new int[X][Y];

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
        sequence(0);
        // board 출력
//        for (int x = 0; x < X; x++) {
//            for (int y = 0; y < Y; y++) {
//                System.out.print(board[x][y]);
//            }
//            System.out.println();
//        }

//        for (Integer blindSpotArea : blindSpotAreas) {
//            System.out.print(blindSpotArea + " ");
//        }
        System.out.println(Collections.min(blindSpotAreas));
        // cctv 감시 영역으로 나올 수 있는 경우의 수 - 순열 구하기

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
            blindSpotAreas.add(getBlindArea(cctvArr)); //해당 상황에서 사각지대 영역을 구해서 저장
            return ;
        }

        for (int i = 0; i < N; i++) {
            cctvArr[k] = i;
            sequence(k + 1);
        }
    }

    private static int getBlindArea(int[] cctvArr) { //cctv 방향이 정해진 배열을 넘겨받음
        // 감시 영역 채우기
        //            board2 = board.clone(); //제대로된 복사가 이루어지지 않음
        board2 = new int[X][Y]; //여기서 초기화하고 새로 만들어줘야함
        // 2차원 배열의 깊은 복사!!!
        for (int x = 0; x < board2.length; x++) {
            System.arraycopy(board[x], 0, board2[x], 0, Y);
        }

        int cctvCount = cctvArr.length;
        for (int i = 0; i < cctvCount; i++) { //각 cctv 별로 감시 영역 그리기
            Cctv cctv = cctvs.get(i);
            board2 = draw(board2, cctv, cctvArr[i]); //해당 cctv랑, cctv 방향정보를 넘김
        }

        // board2가 잘 그려졌는지 확인
//        System.out.println("======= board2 =========");
//        for (int x = 0; x < X; x++) {
//            for (int y = 0; y < Y; y++) {
//                System.out.print(board2[x][y] + " ");
//            }
//            System.out.println();
//        }

        // 감시 영역이 채워진 board에서 사각지대 구하기
        // 방문여부 표시 배열을 초기화 해줘야함
        for (int x = 0; x < X; x++) {
            Arrays.fill(visit[x], 0);
        }
        Queue<Point> q = new LinkedList<>();
        int blindArea = 0;
        int width;

        for (int xi = 0; xi < X; xi++) {
            for (int yi = 0; yi < Y; yi++) {
                if (board2[xi][yi] != 0 || visit[xi][yi] > 0) //board가 0이 아니거나 방문한 곳이면 skip
                    continue;
                q.add(new Point(xi, yi));
                width = 1;

                while (!q.isEmpty()) {
                    Point cur = q.poll();
                    visit[cur.x][cur.y] = 1;

                    //네 빵향 탐색
                    for (int dir = 0; dir < 4; dir++) {
                        int x = cur.x + dx[dir];
                        int y = cur.y + dy[dir];
                        if (x < 0 || x >= X || y < 0 || y >= Y) continue; //범위를 벗어나면
                        if (board2[x][y] != 0 || visit[x][y] > 0) continue; //0(사각지대)이 아니거나 방문한 곳이면
                        q.add(new Point(x, y));
                        visit[x][y] = visit[cur.x][cur.y] + 1;
                        width++;
                    }
                }
                blindArea += width;
            }
        }
        return blindArea;
    }

//    private static int bfs(int blindArea, int startX, int startY) {
//        visit[startX][startY] = blindArea;
//        q.add(new Point(startX, startY));
//        blindArea++;
//
//        return blindArea;
//    }

    private static int[][] draw(int[][] board2, Cctv cctv, int dir) {
        int[] ints = cctv.cctvArea[dir]; //바라보는 방향이 담겨있음

        for (int i = 0; i < ints.length; i++) { //각 바라보는 방향별로 감시영역 그리기
            int curX = cctv.location.x;
            int curY = cctv.location.y;
            while (true) {
                int x = curX + dx[ints[i]];//바라보는 방향으로만 진행해나감
                int y = curY + dy[ints[i]];
                if (x < 0 || x >= X || y < 0 || y >= Y) //이 조건이 먼저 나와야함. 안그러면 잘못된 인덱스 접근
                    break; //보드를 벗어나면 그리기 종료
                if (board2[x][y] == 6) //벽을 만난경우, 해당방향 그리기 종료
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
