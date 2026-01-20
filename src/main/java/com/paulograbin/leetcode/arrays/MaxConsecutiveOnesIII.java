package com.paulograbin.leetcode.arrays;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int currentZeros = 0;
        int longest = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                currentZeros++;
            }

            while (currentZeros > k) {
                if (nums[left] == 0) {
                    currentZeros--;
                }

                left++;
            }

            if (longest < right - left + 1) {
                longest = right - left + 1;
            }

        }

        return longest;
    }

}
