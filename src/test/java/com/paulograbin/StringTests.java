package com.paulograbin;

import net.fellbaum.jemoji.EmojiManager;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTests {

    private final byte[] chars = new byte[]{76, 101, 105, 108, 97, -16, -97, -110, -101};

    @Test
    void stringParsing() {
        String s = new String(chars);
        System.out.println(s);

        assertThat(s).isEqualTo("Leila\uD83D\uDC9B");

        String hex = toHex(s);
        System.out.println(hex);
    }

    @Test
    void name() {
        String s = new String(chars);

        String processedString = EmojiManager.removeAllEmojis(s);

        assertThat(processedString).isEqualTo("Leila");
        System.out.println(toHex(processedString));
    }

    public String toHex(String arg) {
        return String.format("%020x", new BigInteger(1, arg.getBytes(StandardCharsets.UTF_8)));
    }
}
