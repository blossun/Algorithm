package dev.solar.level1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class SimpleTest {
    @Test
    public void simpleTest() {
        String[] str = "Zbcdefg".split("");
        StringBuilder sb = new StringBuilder();
        Stream.of(str).sorted(Comparator.reverseOrder()).forEach(str1 -> sb.append(str1));
        System.out.println(sb.toString());
    }

    @Test
    public void 문자열_다루기_기() {

    }
}
