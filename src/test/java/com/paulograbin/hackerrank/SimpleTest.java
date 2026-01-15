package com.paulograbin.hackerrank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleTest {

    @Test
    public void simpleTest() {
        var response = countResponseTimeRegressions(List.of(4, 100, 200, 150, 300));

        Assertions.assertThat(response).isEqualTo(2);
    }

    @Test
    public void simpleTest1() {
        var response = countResponseTimeRegressions(List.of(0, 100, 200, 150, 300));

        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    public void simpleTest2() {
        var response = countResponseTimeRegressions(List.of(0));

        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    public void simpleTest22() {
        var response = countResponseTimeRegressions(List.of(1, 5));

        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    public void simpleTest222() {
        var response = countResponseTimeRegressions(List.of(2, 5, 5));

        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    public void simpleTest3() {
        var response = countResponseTimeRegressions(List.of(5, 1, 2, 5, 10, 50));

        Assertions.assertThat(response).isEqualTo(4);
    }


    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if (responseTimes.size() < 1) {
            return 0;
        }

        int count = 0;
        long sum = 0;

        for (int i = 1; i < responseTimes.size(); i++) {
            var average = sum / i;

            if (responseTimes.get(i) > average) {
                count += 1;
            }
            sum = sum + responseTimes.get(i);
        }

        return count;
    }

    public static int countResponseTimeRegressionsCorrect(List<Integer> responseTimes) {
        long sum = responseTimes.get(0);
        int result = 0;

        for (int i = 1; i < responseTimes.size(); i++) {
            if (responseTimes.get(i) > sum / i) {
                result += 1;
            }
            sum += responseTimes.get(i);
        }
        return result;
    }
}
