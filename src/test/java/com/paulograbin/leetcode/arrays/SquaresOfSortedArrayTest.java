package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquaresOfSortedArrayTest {

    SquaresOfSortedArray s = new SquaresOfSortedArray();

    @Test
    void name() {
        var nums = new int[]{-4, -1, 0, 3, 10};


        int[] returns = s.sortedSquares(nums);

        Assertions.assertThat(returns[0]).isEqualTo(0);
        Assertions.assertThat(returns[1]).isEqualTo(1);
        Assertions.assertThat(returns[2]).isEqualTo(9);
        Assertions.assertThat(returns[3]).isEqualTo(16);
        Assertions.assertThat(returns[4]).isEqualTo(100);
    }
}