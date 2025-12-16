package com.paulograbin.typeerasure;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeReferenceTest {

    @Test
    void name() {
        TypeReference<Map<String, Integer>> token = new TypeReference<Map<String, Integer>>() {};
        Type type = token.getType();

        assertEquals("java.util.Map<java.lang.String, java.lang.Integer>", type.getTypeName());

        Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
        assertEquals("java.lang.String", typeArguments[0].getTypeName());
        assertEquals("java.lang.Integer", typeArguments[1].getTypeName());
    }
}