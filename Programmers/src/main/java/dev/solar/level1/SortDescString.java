package dev.solar.level1;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortDescString {
    public String solution(String s) {
        String[] str = s.split("");
        StringBuilder sb = new StringBuilder();
        Stream.of(str).sorted(Comparator.reverseOrder()).forEach(str1 -> sb.append(str1));
        return sb.toString();
    }
}
