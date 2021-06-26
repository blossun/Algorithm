package dev.solar.hackerrank;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int where = 0; //현재 위치 고도
        int count = 0;
        char[] chars = path.toCharArray();
        for (char ch : chars) {
            if (ch == 'U') {
                where++;
                if (where == 0) {
                    count++;
                }
            }
            if (ch == 'D') {
                where--;
            }
        }
        return count;
    }
}
