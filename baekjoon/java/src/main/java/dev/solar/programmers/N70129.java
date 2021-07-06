package dev.solar.programmers;

public class N70129 {
    public int[] solution(String s) {

        int countOfTrans = 0;
        int countOfRemovedZero = 0;
        while (!s.equals("1")) {
            String temp = s.replace("0", "");
            countOfRemovedZero += s.length() - temp.length();
            s = Integer.toBinaryString(temp.length());
            countOfTrans++;
        }

        return new int[]{countOfTrans, countOfRemovedZero};
    }
}
