package com.paulograbin.leetcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString reverseString = new ReverseString();

    @Test
    void reverseString1() {
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


    @Test
    void reverseString3() {
        char[] s = {'1'};

        System.out.println(s);
        reverseString.reverseString(s);
        System.out.println(s);

        Assertions.assertThat(s.length).isEqualTo(1);
        Assertions.assertThat(s[0]).isEqualTo('1');
    }

    @Test
    void reverseString4() {
        char[] s = "abc".toCharArray();

        System.out.println(s);
        reverseString.reverseString(s);
        System.out.println(s);

        Assertions.assertThat(s.length).isEqualTo(3);
        Assertions.assertThat(s[0]).isEqualTo('c');
        Assertions.assertThat(s[1]).isEqualTo('b');
        Assertions.assertThat(s[2]).isEqualTo('a');
    }
    @Test
    void reverseString5() {
        char[] s = "abcd".toCharArray();

        System.out.println(s);
        reverseString.reverseString(s);
        System.out.println(s);

        Assertions.assertThat(s.length).isEqualTo(4);
        Assertions.assertThat(s[0]).isEqualTo('d');
        Assertions.assertThat(s[1]).isEqualTo('c');
        Assertions.assertThat(s[2]).isEqualTo('b');
        Assertions.assertThat(s[3]).isEqualTo('a');
    }
}