package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N15649 {
    static int N; //1~N 까지의 자연수
    static int M; //길이가 M인 수열
    static int[] arr = new int[10]; //수열을 담을 배열 //M의 최대 입력값이 8임
    static boolean[] isused = new boolean[10]; //특정 수가 쓰였는지를 true 혹은 false로 나타내는 배열
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        M = sc.nextInt();
        sequence(0);
        bw.flush();
        bw.close();
    }

    private static void sequence(int k) throws IOException { // K : 현재 k개까지 수를 택함.
        //Base Condition
        if (k == M) { //M개를 다 뽑았으면 출력
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write('\n');
            return ;
        }

        for (int i = 1; i <= N; i++) { //범위! 1 ~ N(N 포함) 까지의 수에서 차례로 뽑음
            if (!isused[i]) { //아직 i가 사용되지 않았으면
                arr[k] = i; //K번째 수를 i로 정함
                isused[i] = true; //i를 사용했다고 표시
                sequence(k + 1); //다음 수를 정하러 한 단계 더 들어감
                isused[i] = false; // 여기까지 왔다면, k번째 수를 i로 정한 모든 경우에 대해 다 확인했다는 것. i를 이제 사용되지않았다고 명시함.
            }
        }
    }
}
