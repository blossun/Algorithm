package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Wadiz01Test {
    Wadiz01 wadiz01 = new Wadiz01();

    @Test
    void teamp() {
        String s = "101#1234#102#654321#51#203#201#202#1#";
        String[] split = s.split("#");
        Stream.of(split).forEach(System.out::println);
    }
}
