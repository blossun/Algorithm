package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N15683 {
    //BFS
    static int[][] board; //최초에 입력받은 board를 저장할 변수 - 사무실 모양 저장
    static int[][] board2; //사각 지대의 개수를 세기 위해 사용할 변수 - cctv 방향이 정해졌을 떄 감시영역 표시
    //남-동-북-서 주의!!! 나머지값으로 방향을 돌려줄 것이기 때문에 순서가 맞아야 한다.
    // ex) 북-남-서-동 이런 순서이면 안 됨
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int X;
    static int Y;
    static List<Point> cctvs = new ArrayList<>(); // cctv의 좌표를 저장할 변수

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
        int blindArea = 0; // 사각 지대의 최소 크기 (답)

        // cctv, 벽 입력 받기
        for (int x = 0; x < X; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < Y; y++) {
                int p = Integer.parseInt(st.nextToken());
                board[x][y] = p;
                if (1 <= p && p <= 5) { //cctv 인 경우 cctvs 리스트에 저장
                    cctvs.add(new Point(x, y));
                }
                if (p == 0)
                    blindArea++;
            }
        }

        int numberOdCases = 1 << (2 * cctvs.size()); // 4^(cctv수) 만큼의 경우의 수
        System.out.println("numberOfCases : " + numberOdCases);
        for (int tmp = 0; tmp < numberOdCases; tmp++) {
            board2 = new int[X][Y];
            // 2차원 배열의 깊은 복사!!!
            for (int x = 0; x < board2.length; x++) {
                System.arraycopy(board[x], 0, board2[x], 0, Y);
            }

            int brute = tmp; // 0 ~ 63(numberOfCases : 64개)에 해당하는 수를 4진법으로 표현
            for (int i = 0; i < cctvs.size(); i++) { // i가 해당 숫자의 4진법 각 자리를 가르킴
                int dir = brute % 4; //4진법 각 자리가 방향을 가르킴
                brute /= 4; //해당 수를 4진법으로 표현하기 위해
                // (4진법 수)각 자리에 해당하는 방향(dir)으로 cctv종류(1 ~5)에 따라 감시영역을 7로 표시
                // i번째 cctv의 좌표를 기준으로 cctv 종류를 파악해서 감시구역 표시
                int x = cctvs.get(i).x;
                int y = cctvs.get(i).y;
                System.out.println("[x, y] : " + x + ", " + y + ", cctv : " + board[x][y]);
                if (board[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y,dir + 2);
                } else if (board[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y,dir + 1);
                } else if (board[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y,dir + 1);
                    upd(x, y,dir + 2);
                } else {
                    upd(x, y, dir);
                    upd(x, y,dir + 1);
                    upd(x, y,dir + 2);
                    upd(x, y,dir + 3);
                }
            }
            int val = 0;
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (board2[i][j] == 0)
                        val++;
                }
            }
            blindArea =Math.min(blindArea, val);
            // board2 출력
            System.out.println("================================");
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    System.out.print(board2[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println(blindArea);
    }

    // (x,y)에서 dir 방향으로 진행하면서 벽을 만날 때 까지 지나치는 모든 빈칸을 7로 바꿔버림
    private static void upd(int x, int y, int dir) {
        System.out.print("dir : " + dir + " -> ");
        dir %= 4; //넘겨받은 dir은 0 ~ 6이 넘어올 수 있으므로 4방향으로 구분
        System.out.println(dir);
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) return; // 범위를 벗어났거나 벽을 만나면 함수를 탈출
            if(board2[x][y] != 0) continue; // 해당 칸이 빈칸이 아닐 경우(=cctv가 있을 경우) 넘어감
            board2[x][y] = 7; // 빈칸을 7로 덮음
        }
    }

    // Out of Bounds 확인
    private static boolean OOB(int x, int y) {
        return (x < 0 || x >= X || y < 0 || y >= Y);
    }

}
