package com.paulograbin.leetcode;

public class RunninSum1dArray {

    public int[] runningSum(int[] nums) {
         int[] runningSum = new int[nums.length];

         int sum = 0;

         for (int i = 0; i < nums.length; i++) {
             sum += nums[i];

             runningSum[i] = sum;
         }

         return runningSum;
    }

}
