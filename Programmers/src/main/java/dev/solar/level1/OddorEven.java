package dev.solar.level1;

public class OddorEven {
    public String solution(int num) {
        if (num == 0)
            return "Even";
        return num%2 == 0 ? "Even" : "Odd";
    }
}
