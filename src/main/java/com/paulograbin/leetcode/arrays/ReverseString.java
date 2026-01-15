package com.paulograbin.leetcode.arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int end = s.length - 1;

        for (int i = 0; i <= end; i++) {
            char aux = s[i];

            s[i] = s[end];
            s[end] = aux;

            end--;
        }
    }

}
