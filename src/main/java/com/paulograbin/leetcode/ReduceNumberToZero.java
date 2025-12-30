package com.paulograbin.leetcode;

public class ReduceNumberToZero {

    int response = 0;

    public int numberOfSteps(int num) {
        if (num != 0) {
            if (num % 2 != 0) {
                num = num - 1;
            } else {
                num = num / 2;
            }

            response += 1;

            numberOfSteps(num);
        }

        return response;
    }
}
