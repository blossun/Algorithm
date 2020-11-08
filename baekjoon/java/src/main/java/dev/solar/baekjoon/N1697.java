package dev.solar.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1697 {
    static int[] disit = new int[2000002]; //이동거리 - 2배 만큼 이동할 수 있는 거리를 잡아줌
    // 다음으로 이동할 위치는 -1, 1, 2x 이므로 로직 내에서 처리
    static int start;
    static int end;
    // 2차원 좌표가 아니므로 Point 클래스도 필요하지 않음

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();

        Queue<Integer> q = new LinkedList<>(); // 다음 이동할 지점 대기 큐
        Arrays.fill(disit, -1); // 이동거리 배열을 -1 로 초기화. 방문하지 않은 곳은 -1 임

        // 시작 지점 위치 지정
        disit[start] = 0;
        q.add(start);

        while (q.peek() != end) {
            int cur = q.poll(); //큐에서 다음 시작 위치를 가져옴
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) { // 이동할 수 있는 다음 위치를 bfs로 처
                if (next < 0 || next > 1000000) continue; //범위를 넘어가면 skip리 - 넘어가면 어짜피 가장 빠른 경로가 될 수 없다.
                if (disit[next] != -1) continue; // 이미 방문한 곳이면 skip
                disit[next] = disit[cur] + 1; //이동 거리 저장
                q.add(next); // 다음 시작 위치로 큐에 저장
            }
        }

        System.out.println(disit[end]);
    }
}

/*
1초 후에 갈 수 있는 경로 (x-1, x+1, 2x)의 위치를 bfs로 돌리기

 */
