package com.paulograbin.leetcode.arrays;

public class NumberOfWaysToSplitArray {

    public int solveBruteForce(int[] nums) {
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = 0;

            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                left = left + nums[leftIndex];
            }

            for (int rightIndex = i; rightIndex < nums.length; rightIndex++) {
                right = right + nums[rightIndex];
            }

            if (left >= right) {
                result++;
            }
        }

        return result;
    }

    public int solve(int[] nums) {
        long[] sum = new long[nums.length];

        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        var result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (sum[i] >= sum[sum.length - 1] - sum[i]) {
                result++;
            }
        }

        return result;
    }


}
