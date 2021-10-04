package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void run() {
        List<Integer> i = List.of(13, 14, 15);

        assertThat(i, hasSize(3));
        assertThat(i, hasItems(13, 15));
        assertThat(i, everyItem(greaterThan(5)));
        assertThat(i, everyItem(lessThan(50)));

        assertThat("", is(blankOrNullString()));
        assertThat(null, is(blankOrNullString()));
        assertThat("WORLD", is(containsString("OR")));
        assertThat("WORLD", is(startsWith("WO")));
        assertThat("WORLD", is(not(startsWith("AB"))));
        assertThat("WORLD", is(endsWith("LD")));

    }

}
