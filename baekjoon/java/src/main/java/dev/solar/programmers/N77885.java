package dev.solar.programmers;

public class N77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            long nextNumber = number;
            while (true) {
                nextNumber++;
                int bitCount = Long.bitCount(number ^ nextNumber);
                if (bitCount == 1 || bitCount == 2) {
                    answer[i] = nextNumber;
                    break;
                }
            }
        }
        return answer;
    }
}
