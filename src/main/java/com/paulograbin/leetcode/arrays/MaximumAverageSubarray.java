package com.paulograbin.leetcode.arrays;

public class MaximumAverageSubarray {

    /*
        Sliding window
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        System.out.println("len is " + nums.length);

        for (int i = 0; i < k; i++) {
            System.out.println(i);
            sum = sum + nums[i];
        }

        double res = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];

//            System.out.println(i + " - " + (i - k));

            res = Math.max(res, sum);
        }

        return 0;
    }

//    /*
//        Using cumulative array
//     */
//    public double findMaxAverage(int[] nums, int k) {
//        int[] sum = new int[nums.length];
//
//        sum[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i];
//        }
//
//        double res = sum[k - 1] * 1.0 / k;
//
//        for (int i = k; i < nums.length; i++) {
//            var cur = (sum[i] - sum[i - k]) * 1.0 / k;
//
//            System.out.println(i + " - " + (i - k));
//
//            if (cur > res)
//                res = cur;
//        }
//
//        return res;
//    }

}
