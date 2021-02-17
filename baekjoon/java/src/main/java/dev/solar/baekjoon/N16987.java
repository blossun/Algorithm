package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class N16987 {
    private static int N;
    private static Egg[] eggs;
    private static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bt(0);
        System.out.println(count);
    }

    private static void bt(int pick) { // k번째 집어든 계란을 확인
        count = Math.max(Stream.of(eggs).filter(egg -> egg.durability <= 0).count(), count);
        if (pick == N) { //k가 N번째 계란인 경우, 하나의 경우 완성
            return;
        }

        if (eggs[pick].durability > 0) { //집어든 계란이 깨지지 않은 경우
            for (int target = 0; target < N; target++) { //자기자신과 왼쪽(이미 지나온 계란)은 확인 X
                if (eggs[target].durability > 0 && target != pick) { // 타겟의 계란이 깨지지 않은 상태이고, 자기 자신이 아닌 경우
                    eggs[pick].durability -= eggs[target].weight;
                    eggs[target].durability -= eggs[pick].weight;
                    bt(pick + 1);
                    eggs[pick].durability += eggs[target].weight;
                    eggs[target].durability += eggs[pick].weight;
                }
            }
        } else { // 집어들 계란이 깨져있는 경우
            bt(pick + 1); //오른쪽 계란 집어들기
        }
    }

    private static class Egg {
        private int durability;
        private int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
