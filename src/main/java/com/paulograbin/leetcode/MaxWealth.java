package com.paulograbin.leetcode;

public class MaxWealth {
    public int maximumWealth(int[][] accounts) {

        int wealth = 0;
        int tempSum = 0;

        for (int[] account : accounts) {
            tempSum = 0;

            for (int i : account) {
                tempSum += i;
            }


            if (tempSum > wealth) {
                wealth = tempSum;
            }
        }

        return wealth;
    }
}
