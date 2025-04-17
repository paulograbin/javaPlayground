package com.paulograbin;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class LambdaTests {

    @Test
    void testOneA() {
        var a = Optional.of("aaa").orElse("aaa");

        // will execute test()
        var b = Optional.of("aaa").orElse(test());
    }

    @Test
    void testOneB() {
        // will not execute test()
        Optional.empty().orElseGet(this::test);
    }

    @Test
    void testOneAAAA() {
        Optional.of("aaa").orElseGet(this::test);
    }

    private String test() {
        System.out.println("Entrou aqui ehein...");

        return "OrElse";
    }

    @Test
    void testThree() {
        String user = makeEmptyOptional().orElse("Executing orElse");
        System.out.println(user);

        String user2 = makeEmptyOptional().orElseGet(() -> "Executing orElseGet");
        System.out.println(user2);

        String user3 = makeNonOptional().orElseGet(() -> "Executing orElseGet again");
        System.out.println(user3);
    }

    private Optional<String> makeNonOptional() {
        return Optional.of("Present!!");
    }

    private Optional<String> makeEmptyOptional() {
        return Optional.empty();
    }
}
