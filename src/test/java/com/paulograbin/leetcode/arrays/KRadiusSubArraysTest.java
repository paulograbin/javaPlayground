package com.paulograbin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KRadiusSubArraysTest {

    KRadiusSubArrays sub = new KRadiusSubArrays();

    @Test
    void basic() {
        int[] nums = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};

        int[] averages = sub.getAverages(nums, 3);

        assertThat(averages).isEqualTo(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1});
    }

    @Test
    void anotjher() {
        int[] nums = new int[]{100000};

        int[] averages = sub.getAverages(nums, 0);

        assertThat(averages).isEqualTo(new int[]{100000});
    }

    @Test
    void yetAnother() {
        int[] nums = new int[]{8};

        int[] averages = sub.getAverages(nums, 100000);

        assertThat(averages).isEqualTo(new int[]{-1});
    }


    @Test
    void testCase1() {
        int[] nums = new int[]{40527, 53696, 10730, 66491, 62141, 83909, 78635, 18560};

        int[] averages = sub.getAverages(nums, 2);

        assertThat(averages).isEqualTo(new int[]{-1, -1, 46717, 55393, 60381, 61947, -1, -1});
    }
}