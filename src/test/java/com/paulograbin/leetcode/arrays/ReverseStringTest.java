package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString reverseString = new ReverseString();

    @Test
    void reverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        System.out.println(s);
        reverseString.reverseString(s);
        System.out.println(s);

        Assertions.assertThat(s.length).isEqualTo(5);
        Assertions.assertThat(s[0]).isEqualTo('o');
        Assertions.assertThat(s[1]).isEqualTo('l');
        Assertions.assertThat(s[4]).isEqualTo('h');
    }

    @Test
    void reverseString2() {
        char[] s = {'1', '2', '3', '4', '5'};

        System.out.println(s);
        reverseString.reverseString(s);
        System.out.println(s);

        Assertions.assertThat(s.length).isEqualTo(5);
        Assertions.assertThat(s[0]).isEqualTo('5');
        Assertions.assertThat(s[1]).isEqualTo('4');
        Assertions.assertThat(s[2]).isEqualTo('3');
        Assertions.assertThat(s[3]).isEqualTo('2');
        Assertions.assertThat(s[4]).isEqualTo('1');
    }
}