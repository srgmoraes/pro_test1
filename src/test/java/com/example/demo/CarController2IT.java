package com.example.demo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class CarController2IT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() throws JSONException {

        String response  = testRestTemplate.getForObject("/car-all-from-database", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false);

    }

}
