package dev.solar.level1;

public class TreatNormalString {
    public boolean solution(String s) {
        if (s.length()!=4 && s.length()!=6)
            return false;
        try {
            int num = Integer.parseInt(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
