package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunningSumOf1dArrayTest {

    RunningSumOf1dArray sum = new RunningSumOf1dArray();

    @Test
    void one() {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] expected = new int[]{1, 3, 6, 10};

        int[] solution = sum.runningSum(nums);

        Assertions.assertThat(solution).isEqualTo(expected);
    }

    @Test
    void two() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] solution = sum.runningSum(nums);

        Assertions.assertThat(solution).isEqualTo(expected);
    }

    @Test
    void three() {
        int[] nums = new int[]{3, 1, 2, 10, 1};
        int[] expected = new int[]{3, 4, 6, 16, 17};

        int[] solution = sum.runningSum(nums);

        Assertions.assertThat(solution).isEqualTo(expected);
    }
}