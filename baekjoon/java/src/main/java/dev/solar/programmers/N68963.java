package dev.solar.programmers;

public class N68963 {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        div(0, 0, arr.length, arr);
        return answer;
    }

    private void div(final int x, final int y, final int length, final int[][] arr) {
        boolean isZero = true;
        boolean isOne = true;

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] == 1) isZero = false;
                if (arr[i][j] == 0) isOne = false;
            }
        }

        if (isZero) {
            answer[0]++;
            return ;
        }
        if (isOne) {
            answer[1]++;
            return ;
        }

        // 0과 1이 섞여있으면 아무것도 카운팅하지 않고, 더 잘게 쪼개서 카운팅 한다.
        div(x, y, length / 2, arr);
        div(x + length/2, y, length / 2, arr);
        div(x, y + length/2, length / 2, arr);
        div(x + length/2, y + length/2, length / 2, arr);
    }

}
