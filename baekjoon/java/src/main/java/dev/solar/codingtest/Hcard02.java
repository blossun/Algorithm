package dev.solar.codingtest;

public class Hcard02 {
    boolean[] used;
    int[] number;
    int result = 0;

    public int solution(int k, int m) {//1~k로 만들 수 있는 K자리 갯수 자연수
        used = new boolean[k + 1];
        number = new int[k];

        dfs(0, k, m);


        return result;
    }

    private void dfs(int cur, int k, int m) {
        if (cur == k) { //k개를 다 뽑았으면 확인
            System.out.println(convertNumber());
            if (convertNumber() % m == 0) {
                result++;
            }
            return ;
        }

        for (int i = 1; i <= k; i++) { //1~k(k포함) 까지의 수에서 차례로 뽑음
            if (!used[i]) {
                number[cur] = i;
                used[i] = true;
                dfs(cur + 1, k, m);
                used[i] = false;
            }
        }

    }

    private int convertNumber() {
        return number[0] * 100 + number[1] * 10 + number[2];
    }
}
