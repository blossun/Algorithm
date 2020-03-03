package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreatNormalStringTest {
    TreatNormalString treatNormalString = new TreatNormalString();

    @Test
    void solution() {
        boolean actual = treatNormalString.solution("a234");
        assertFalse(actual);
    }

    @Test
    void solution2() {
        assertTrue(treatNormalString.solution("1234"));
    }
}
