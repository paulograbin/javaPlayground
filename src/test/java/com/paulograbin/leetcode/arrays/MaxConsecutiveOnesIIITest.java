package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxConsecutiveOnesIIITest {

    private MaxConsecutiveOnesIII max = new MaxConsecutiveOnesIII();

    @Test
    void basic() {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int longest = max.longestOnes(a, 2);

        Assertions.assertThat(longest).isEqualTo(6);
    }

    @Test
    void basic2() {
        int[] a = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int longest = max.longestOnes(a, 3);

        Assertions.assertThat(longest).isEqualTo(10);
    }
}