package io.github.pavelixo.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spark.Spark.port;
import static spark.Spark.stop;
import static spark.Spark.awaitInitialization;

public class HelloControllerTest {

    @BeforeAll
    public static void setup() throws Exception {
        stop();
        Thread.sleep(100);
        port(8080);
        new HelloController().register();
        awaitInitialization();
    }


    @AfterAll
    public static void teardown() {
        stop();
    }

    @Test
    public void testHelloEndpoint() throws Exception {
        URL url = new URL("http://localhost:8080/hello");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        assertEquals(200, responseCode, "HTTP response code should be 200");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String responseBody = in.readLine();
            assertEquals("Hello, World!", responseBody, "Response body should be 'Hello, World!'");
        }
    }
}
