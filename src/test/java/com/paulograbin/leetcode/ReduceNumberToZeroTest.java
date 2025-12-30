package com.paulograbin.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReduceNumberToZeroTest {

    private final ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();

    @Test
    void testOne() {
        int i = reduceNumberToZero.numberOfSteps(14);

        assertEquals(6, i);
    }

    @Test
    void testTwo() {
        int i = reduceNumberToZero.numberOfSteps(8);

        assertEquals(4, i);
    }

    @Test
    void testThree() {
        int i = reduceNumberToZero.numberOfSteps(123);

        assertEquals(12, i);
    }
}