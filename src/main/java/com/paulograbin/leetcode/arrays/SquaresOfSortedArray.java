package com.paulograbin.leetcode.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquaresSimple(int[] nums) {
        int[] squares = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = nums[i] * nums[i];
        }

        Arrays.sort(squares);

        return squares;
    }


    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length-1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                squares[i] = nums[left] * nums[left];
                left++;
            } else {
                squares[i] = nums[right] * nums[right];
                right--;
            }
        }

        return squares;
    }
}
