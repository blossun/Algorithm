package dev.solar.temp;

public class Woo01 {
    public int[] solution(int money) {
        // 오만, 만, 오천, 천, 오백, 백, 오십, 십, 일
        int[] result = new int[9];
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++) {
            result[i] = money / bill[i];
            money %= bill[i];
        }
        return result;
    }
}
