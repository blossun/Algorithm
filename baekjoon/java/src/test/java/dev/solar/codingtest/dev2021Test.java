package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dev2021Test {
    Dev2021of01 dev2021Of01 = new Dev2021of01();

    @Test
    void case01() {
        String[] registeredList = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String new_id = "ace15";
        String expected = "ace15";
        assertEquals(expected, dev2021Of01.solution(registeredList, new_id));
    }

    @Test
    void case02() {
        String[] registeredList = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String new_id = "cow";
        String expected = "cow10";
        assertEquals(expected, dev2021Of01.solution(registeredList, new_id));
    }

    @Test
    void temp() {
        String str = "abc";
        System.out.println(findNumber(str));
        str = "abc123";
        System.out.println(findNumber(str));
        System.out.println(str.substring(findNumber(str)));
    }

    public int findNumber(String str) {
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                index = i;
                break;
            }
        }
        return index;
    }
}
