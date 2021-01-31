package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Math.max;

public class N6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        int[] arr = new int[N + 2];
        int heighest = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            arr[i] = height;
            heighest = max(heighest, height);
        }
        Stack<Building> rBuildingStack = new Stack<>();
        rBuildingStack.add(new Building(N, heighest + 1)); //제일 높은빌딩보다 더 높은 빌딩을 오른쪽에 세움
        for (int i = N - 1; i >= 0; i--) {
            int currentHeight = arr[i]; //현재 견물의 높이
            while (!rBuildingStack.isEmpty()) {
                if (currentHeight <= rBuildingStack.peek().height) { //나보다 높은 빌딩을 만난 경우
                    cnt += rBuildingStack.peek().index - i - 1;
//                    System.out.println("[hi] i : " + i + ", peek index : " + rBuildingStack.peek().index);
                    rBuildingStack.push(new Building(i, currentHeight));
                    break;
                }
                //오른쪽이 나보다 낮은 빌딩인 경우
                rBuildingStack.pop();
            }
        }
        System.out.println(cnt);
    }

    private static class Building {
        int index;
        int height;

        public Building(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

