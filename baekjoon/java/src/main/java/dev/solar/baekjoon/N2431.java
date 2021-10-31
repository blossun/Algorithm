package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2431 {
    static int N, d, k, c;
    static int[] arr;
    static int[] eated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken()); //접시 수
        d = Integer.parseInt(tokenizer.nextToken()); //가짓 수
        k = Integer.parseInt(tokenizer.nextToken()); //연속해서 먹는 접시 수
        c = Integer.parseInt(tokenizer.nextToken()); //쿠폰 번호
        arr = new int[N];
        eated = new int[d + 1]; //번호마다 먹은 스시 갯수 저장 (이미 먹은 번호인 경우 카운팅하지 않음

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(slide());
    }

    private static int slide() {
        int inSlide = 0; //k 크기의 슬라이드 내에서 먹은 중복없는 스시 수
        int chance; //찬스까지 고려해서 먹은 수

        // 처음 k개의 슬라이드에 담기
        for (int i = 0; i < k; i++) {
            if (eated[arr[i]] == 0) {
                inSlide++;
            }
            eated[arr[i]]++;
        }
        chance = inSlide;

        for (int i = 1; i < N; i++) { //주의 - 1부터 시작해야한다.
            if (chance <= inSlide) {
                chance = inSlide;
                if (eated[c] == 0) { //슬라이드에 찬스 번호가 없으면 1개 더 먹을 수 있음
                    chance++;
                }
            }
            // 슬리이드 이동
            // 앞쪽 스시는 못먹게 된다. 이후 한번도 먹은적이 없으면 슬라이드 내에서 먹은 스시 갯수 -1
            eated[arr[i - 1]]--;
            if (eated[arr[i - 1]] == 0) {
                inSlide--;
            }
            // 뒤쪽 스시를 먹게 된다. 이전에 한번도 먹은적이 없으면 슬라이드 내에서 먹은 스시 갯수 -1
            // 회전초밥의 회전을 고려해서 % N 으로 계산해줘야한다.
            if (eated[arr[(i + k - 1) % N]] == 0) {
                inSlide++;
            }
            eated[arr[(i + k - 1) % N]]++;
        }

        return chance;
    }
}
