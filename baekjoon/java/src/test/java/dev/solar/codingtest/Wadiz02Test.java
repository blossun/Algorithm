package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Wadiz02Test {
    Wadiz02 wadiz02 = new Wadiz02();

    @Test
    void case01() {
        String[] code = {"a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"};
        String[] expected = {"a=4", "a=6", "b=3", "a=4", "a=7", "a=3", "error", "a=4", "a=4"};
        String[] actual = wadiz02.solution(code);
        assertArrayEquals(expected, actual);
    }

    @Test
    void temp() {
        String op = ".......print b";
        System.out.println(op.lastIndexOf('.')); //6
        op = "print b";
        System.out.println(op.lastIndexOf('.')); //6
        op = ".print b";
        System.out.println(op.lastIndexOf('.')); //6
    }
}
