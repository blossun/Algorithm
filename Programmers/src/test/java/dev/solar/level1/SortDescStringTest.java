package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortDescStringTest {
    SortDescString sortDescString = new SortDescString();

    @Test
    void solution() {
        String expected = "gfedcbZ";
        String actual = sortDescString.solution("Zbcdefg");
        assertEquals(expected, actual);
    }
}
