package com.paulograbin.leetcode.arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start <= end) {
            char save = s[end];

            s[end] = s[start];
            s[start] = save;

            start++;
            end--;
        }
    }
}
