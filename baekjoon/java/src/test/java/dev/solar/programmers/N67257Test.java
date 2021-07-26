package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class N67257Test {

    N67257 n67257 = new N67257();

    @Test
    public void temp() {
        String expression = "100-200*300-500+20";
        List<Long> numberList = new LinkedList<>(Arrays.asList(Arrays.stream(expression.replaceAll("[\\D]", " ") //숫자만 남도록
                .split(" "))
                .mapToLong(Long::parseLong)
                .boxed()
                .toArray(Long[]::new)));

        List<String> operandList = Arrays.stream(expression.replaceAll("[\\d]", "") //숫자가 아닌 문자만 남도록
                .split(""))
                .collect(Collectors.toList());

        List<Long> expectedNumberList = new LinkedList<>();
        expectedNumberList.add(100L);
        expectedNumberList.add(200L);
        expectedNumberList.add(300L);
        expectedNumberList.add(500L);
        expectedNumberList.add(20L);
        assertThat(numberList).isEqualTo(expectedNumberList);

        List<String> expectedOperandList = new LinkedList<>(Arrays.asList("-", "*", "-", "+"));
        assertThat(operandList).isEqualTo(expectedOperandList);
    }

    @Test
    public void case01() {
        String expression = "100-200*300-500+20";
        long expected = 60420;
        long actual = n67257.solution(expression);
        assertThat(actual).isEqualTo(expected);
    }
}
