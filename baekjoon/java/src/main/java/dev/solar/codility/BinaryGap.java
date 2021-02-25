package dev.solar.codility;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(9));
    }

    public int solution(int N) {
        char[] binaryNumber = Integer.toBinaryString(N).toCharArray();
        int countOfZero = 0;
        int maxCountOfZero = 0;
        boolean isAppeardOne = false;

        for (char c : binaryNumber) {
            if (c == '1') {
                if (!isAppeardOne) {
                    isAppeardOne = true;
                } else { //1 이 등장하면 이번에 나온 0의 길이 값을 비교해서 최대 길이값을 갱신하고
                    maxCountOfZero = Math.max(maxCountOfZero, countOfZero);
                    countOfZero = 0; //다시 0개부터 카운팅
                }
            } else {
                countOfZero++;
            }
        }
        return maxCountOfZero;
    }

}
