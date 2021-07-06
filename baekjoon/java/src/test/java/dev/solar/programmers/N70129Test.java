package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N70129Test {

    N70129 n70129 = new N70129();

    @Test
    void temp() {
        System.out.println(Integer.parseInt("1111", 2));
        Integer i = Integer.parseInt("1111", 2); //15
        int bitCount = Integer.bitCount(i);
        System.out.println(bitCount); //4
        System.out.println(Integer.toBinaryString(15)); //1111(2)
    }

    @Test
    void case01() {
        String s = "110010101001";
        int[] expected = new int[]{3,8};
        int[] actual = n70129.solution(s);
        assertArrayEquals(expected, actual);
    }
}
