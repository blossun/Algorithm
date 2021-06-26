package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N49993Test {

    N49993 n49993 = new N49993();

    @Test
    void case01() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        assertThat(2).isEqualTo(n49993.solution(skill, skill_trees));
    }
}
