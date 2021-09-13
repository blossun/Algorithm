package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N43164Test {
    N43164 n43164 = new N43164();

    @Test
    void case01() {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] expected = {"ICN", "JFK", "HND", "IAD"};
        assertArrayEquals(expected, n43164.solution(tickets));
    }

    @Test
    void case02() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] expected = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        assertArrayEquals(expected, n43164.solution(tickets));
    }

    @Test
    void case03() {
        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
        String[] expected = {"ICN", "B", "ICN", "A"};
        assertArrayEquals(expected, n43164.solution(tickets));
    }
}
