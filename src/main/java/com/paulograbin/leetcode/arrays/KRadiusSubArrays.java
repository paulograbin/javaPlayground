package com.paulograbin.leetcode.arrays;

public class KRadiusSubArrays {

    public int[] getAverages(int[] nums, int k) {
        int[] averages = new int[nums.length];
        for (int i = 0; i < averages.length; i++) {
            averages[i] = -1;
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        if (k == 0) {
            return nums;
        }

        for (int i = k; i < sum.length - k; i++) {
            long currentSum;
            if (i - k - 1 < 0) {
                currentSum = sum[i + k];
            } else {
                currentSum = sum[i + k] - sum[i - k];
            }

            long currentAverage = currentSum / ((2L * k) + 1);
            averages[i] = (int) currentAverage;
        }

        return averages;
    }

}
