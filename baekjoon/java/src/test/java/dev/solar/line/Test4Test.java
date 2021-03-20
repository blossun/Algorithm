package dev.solar.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test4Test {
    private Test4 test4;

    @BeforeEach
    void setUp() {
        test4 = new Test4();
    }

    @Test
    void test1() {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};
        boolean[] expected = {true, false};
        assertArrayEquals(expected, test4.solution(program, flag_rules, commands));
    }


    @Test
    void test2() {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -e Bye"};
        boolean[] expected = {false};
        assertArrayEquals(expected, test4.solution(program, flag_rules, commands));
    }

    @Test
    void test3() {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -s 123 -n HI", "line fun"};
        boolean[] expected = {false, false};
        assertArrayEquals(expected, test4.solution(program, flag_rules, commands));
    }

    @Test
    void test4() {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line fun"};
        boolean[] expected = {false};
        assertArrayEquals(expected, test4.solution(program, flag_rules, commands));
    }

    @Test
    void test5() {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -s -n"};
        boolean[] expected = {false};
        assertArrayEquals(expected, test4.solution(program, flag_rules, commands));
    }
}
