package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfWaysToSplitArrayTest {

    NumberOfWaysToSplitArray num = new NumberOfWaysToSplitArray();

    @Test
    void zero() {
        int[] nums = new int[]{0, 0};

        int bruteForceResult = num.solveBruteForce(nums);
        Assertions.assertThat(bruteForceResult).isEqualTo(1);

        int optimalResult = num.solve(nums);
        Assertions.assertThat(optimalResult).isEqualTo(1);
    }

    @Test
    void negative() {
        int[] nums = new int[]{-1, -5};

        int bruteForceResult = num.solveBruteForce(nums);
        Assertions.assertThat(bruteForceResult).isEqualTo(1);

        int optimalResult = num.solve(nums);
        Assertions.assertThat(optimalResult).isEqualTo(1);
    }

    @Test
    void generatedNegatives() {
        int[] nums = new int[100_000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -i;
        }

        int bruteForceResult = num.solveBruteForce(nums);
        Assertions.assertThat(bruteForceResult).isEqualTo(70710);

        int optimalResult = num.solve(nums);
        Assertions.assertThat(optimalResult).isEqualTo(70710);
    }

    @Test
    void name() {
        int[] nums = new int[]{10, 4, -8, 7};

        int bruteForceResult = num.solveBruteForce(nums);
        Assertions.assertThat(bruteForceResult).isEqualTo(2);

        int optimalResult = num.solve(nums);
        Assertions.assertThat(optimalResult).isEqualTo(2);
    }

    @Test
    void second() {
        int[] nums = new int[]{2, 3, 1, 0};

        int bruteForceResult = num.solveBruteForce(nums);
        Assertions.assertThat(bruteForceResult).isEqualTo(2);

        int optimalResult = num.solve(nums);
        Assertions.assertThat(optimalResult).isEqualTo(2);
    }
}