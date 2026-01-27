package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KRadiusSubArraysTest {

    KRadiusSubArrays sub = new KRadiusSubArrays();

    @Test
    void basic() {
        int[] nums = new int[]{8};

        int[] averages = sub.getAverages(nums, 8);

        Assertions.assertThat(averages).isEqualTo(new int[]{-1});
    }

    @Test
    void anotjher() {
        int[] nums = new int[]{8};

        int[] averages = sub.getAverages(nums, 8);

        Assertions.assertThat(averages).isEqualTo(new int[]{-1});
    }

    @Test
    void yetAnother() {
        int[] nums = new int[]{8};

        int[] averages = sub.getAverages(nums, 8);

        Assertions.assertThat(averages).isEqualTo(new int[]{-1});

    }
}