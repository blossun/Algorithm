package dev.solar.naver;

public class Webtoon03 {
    public int solution(String s, String t) {
        int result = 0;
        while (true) {
            int indexOfT = s.indexOf(t);
            if (indexOfT < 0) {
                break;
            }
            s = s.replaceFirst(t, "");
            result++;
        }
        return result;
    }
}
