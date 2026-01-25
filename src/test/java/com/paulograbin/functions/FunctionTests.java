package com.paulograbin.functions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTests {

    @Test
    void oneFunction() {
        Function<Integer, Integer> minutesToSeconds = minutes -> minutes * 60;
        Integer seconds = minutesToSeconds.apply(1);

        assertThat(seconds).isEqualTo(60);
    }

    @Test
    void twoFunctions() {
        Function<Integer, Function<Integer, Integer>> toSecondsFunction = hours -> minutes -> hours * 3600 + minutes * 60;
        Integer seconds = toSecondsFunction.apply(1).apply(16);

        assertThat(seconds).isEqualTo(4560);
    }

    @Test
    void test3() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> toSecondsFunction =
                hours ->
                        minutes ->
                                seconds ->
                                        hours * 3600 + minutes * 60 + seconds;
        Integer seconds = toSecondsFunction.apply(1).apply(16).apply(1);

        assertThat(seconds).isEqualTo(4561);
    }

    @FunctionalInterface
    interface AddSeconds {
        int addSeconds(int secondsToAdd);
    }

    @FunctionalInterface
    interface AddMinutes {
        AddSeconds addMinutes(int minutesToAdd);
    }

    @FunctionalInterface
    interface SecondsCalculator {
        AddMinutes addHours(int hoursToAdd);
    }

    @Test
    void finalTest() {
        SecondsCalculator secondsCalculator = h -> m -> s -> (h * 3600 + m * 60 + s);

        AddMinutes addMinutes = secondsCalculator.addHours(1);
        AddSeconds addSeconds = addMinutes.addMinutes(16);
        int result = addSeconds.addSeconds(1);

        assertThat(result).isEqualTo(4561);
    }
}
