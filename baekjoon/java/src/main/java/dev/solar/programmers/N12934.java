package dev.solar.programmers;

public class N12934 {
    public long solution(long n) {
        Double sqrt = Math.sqrt(n);

        if (sqrt == sqrt.intValue()) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1;
    }
}
