package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void run() {
        List<Integer> i = List.of(13, 14, 15);

        assertThat(i)
                .hasSize(3)
                .contains(13, 15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .isNotEmpty();

        assertThat("").isEmpty();
        assertThat("WORLD").isNotNull().contains("OR").startsWith("WO").endsWith("LD");

    }

}
