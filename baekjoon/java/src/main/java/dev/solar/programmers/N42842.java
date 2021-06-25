package dev.solar.programmers;

public class N42842 {
    public int[] solution(int brown, int yellow) {
        /**
         * X(가로), Y(세로)
         * X + Y = (brown) / 2 + 2
         * yellow = (x - 2) * (y - 2)
         */
        int[] answer = new int[2];
        int sumOfXY = brown / 2 + 2;
        for (int x = 0; x < sumOfXY; x++) {
            for (int y = 0; y <= x; y++) {
                if (checkBrown(x, y, brown) && checkYellow(x, y, yellow)) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean checkBrown(int x, int y, int brown) {
        return brown / 2 + 2 == x + y;
    }

    private boolean checkYellow(int x, int y, int yellow) {
        return (x - 2) * (y - 2) == yellow;
    }
}
