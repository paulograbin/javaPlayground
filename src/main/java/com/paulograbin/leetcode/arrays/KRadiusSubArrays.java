package com.paulograbin.leetcode.arrays;

import java.util.Arrays;

public class KRadiusSubArrays {

    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int[] averages = new int[nums.length];
        for (int i = 0; i < averages.length; i++) {
            averages[i] = -1;
        }

        int windowSize = 2 * k + 1;

        if (windowSize > nums.length) {
            return averages;
        }

        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        System.out.println(Arrays.toString(prefix));

        for (int i = k; i < nums.length - k; i++) {
            long sum = prefix[i + k + 1] - prefix[i - k];
            averages[i] = (int) (sum / windowSize);
        }

        return averages;
    }

}
