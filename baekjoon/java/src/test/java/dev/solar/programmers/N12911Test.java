package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12911Test {

    N12911 n12911 = new N12911();

    @Test
    void temp() {
        int num = 15;
        String expectedBinaryNum = "1111";
        String actual = Integer.toBinaryString(15);
        assertThat(expectedBinaryNum).isEqualTo(actual);
    }

    @Test
    void tesm2() {
        String binaryNumber = "1111";
        int lastIndexOfOne = binaryNumber.lastIndexOf('1');
        int expected = 3;
        assertThat(lastIndexOfOne).isEqualTo(expected);
    }

    @Test
    void tesm3() {
        String binaryNumber = "1";
        int lastIndexOfOne = binaryNumber.lastIndexOf('1');
        int expected = 0;
        assertThat(lastIndexOfOne).isEqualTo(expected);
    }

    @Test
    void temp4() {
        char[] chars = {'1', '0', '1', '0', '0', '1', '1'};
        String str = String.valueOf(chars);
        System.out.println(str);
        System.out.println(Integer.parseInt(String.valueOf(chars),2));
    }

    @Test
    void case01() {
        assertThat(n12911.solution(78)).isEqualTo(83);
    }

    @Test
    void case02() {
        assertThat(n12911.solution(15)).isEqualTo(23);
    }

    @Test
    void temp05() {
        System.out.println(Integer.bitCount(15)); //1111 -> 4
        System.out.println(Integer.bitCount(78)); //1001110 -> 4
    }
}
