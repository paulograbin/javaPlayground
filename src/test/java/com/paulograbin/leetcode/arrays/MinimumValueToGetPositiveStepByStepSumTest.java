package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MinimumValueToGetPositiveStepByStepSumTest {

    MinimumValueToGetPositiveStepByStepSum steps = new MinimumValueToGetPositiveStepByStepSum();

    @Test
    void basic() {
        int steps = this.steps.minStartValue(new int[]{-3, 2, -3, 4, 2});

        Assertions.assertThat(steps).isEqualTo(5);
    }

    @Test
    void second() {
        int steps = this.steps.minStartValue(new int[]{1, 2});

        Assertions.assertThat(steps).isEqualTo(1);
    }

    @Test
    void third() {
        int steps = this.steps.minStartValue(new int[]{1, -2, -3});

        Assertions.assertThat(steps).isEqualTo(5);
    }
}