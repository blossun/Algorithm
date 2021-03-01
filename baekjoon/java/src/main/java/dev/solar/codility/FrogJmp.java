package dev.solar.codility;

public class FrogJmp {
    public int solution(int curPos, int destPos, int jumpDistance) {
        // (destPos - curPos) / jumDistance

        return (int) Math.ceil((double) (destPos - curPos) / jumpDistance);
    }
}
