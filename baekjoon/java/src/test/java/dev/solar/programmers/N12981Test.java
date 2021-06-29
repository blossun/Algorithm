package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N12981Test {

    N12981 n12981 = new N12981();

    @Test
    void case01() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] actual = n12981.solution(n, words);
        int[] expected = new int[] {3, 3};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case02() {
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int[] actual = n12981.solution(n, words);
        int[] expected = new int[] {0, 0};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case03() {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] actual = n12981.solution(n, words);
        int[] expected = new int[] {1, 3};
        assertThat(actual).isEqualTo(expected);
    }
}
