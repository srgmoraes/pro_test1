package com.example.demo;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {


    @Test
    public void run() {
        String response =  "[{id:1001, color=\"Blue\"},{id:1002, color=\"Red\"},{id:1003, color=\"Gray\"}]";

        DocumentContext context = JsonPath.parse(response);

        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1001, 1002, 1003);

        System.out.println(context.read("$[1]").toString());
        System.out.println(context.read("$[0:1]").toString());
        System.out.println(context.read("$[?(@.color=='Red')]").toString());

    }
}
