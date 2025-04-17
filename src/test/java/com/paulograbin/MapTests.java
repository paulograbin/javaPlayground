package com.paulograbin;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class MapTests {

    private final Map<String, Boolean> featureMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        featureMap.put("AAA", Boolean.TRUE);
        featureMap.put("BBB", Boolean.TRUE);
    }

    @Test
    void existingKey() {
        String featureKey = "AAA";

        assertThat(featureMap.get(featureKey)).isTrue();

        featureMap.computeIfPresent(featureKey, (s, aBoolean1) -> !aBoolean1);
        assertThat(featureMap.get(featureKey)).isFalse();

        featureMap.computeIfPresent(featureKey, (s, aBoolean1) -> !aBoolean1);
        assertThat(featureMap.get(featureKey)).isTrue();
    }

    @Test
    void nonExistingKey() {
        String featureKey = "111";

        assertThat(featureMap.get(featureKey)).isNull();

        Boolean aBoolean = featureMap.computeIfPresent(featureKey, (s, aBoolean1) -> aBoolean1);
        assertThat(featureMap.get(featureKey)).isNull();
        assertThat(featureMap.get(aBoolean)).isNull();
    }

    @Test
    void name() {
        System.out.println(BooleanUtils.isTrue(null));
        System.out.println(BooleanUtils.isTrue(true));
        System.out.println(BooleanUtils.isTrue(false));
    }
}