package com.paulograbin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RunninSum1dArrayTest {

    @Test
    void name() {
        RunninSum1dArray runningSum1dArray = new RunninSum1dArray();

        int[] ints = runningSum1dArray.runningSum(new int[]{1, 2, 3, 4, 5});

        System.out.println(Arrays.toString(ints));
    }
}