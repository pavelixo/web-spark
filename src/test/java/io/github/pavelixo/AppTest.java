package io.github.pavelixo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {

    @BeforeAll
    public static void setup() throws Exception {
        App.main(new String[]{});
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDown() {
        spark.Spark.stop();
    }

    @Test
    public void testHelloRoute() throws Exception {
        URL url = new URL("http://localhost:8080/hello");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertEquals(200, con.getResponseCode());

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String content = in.readLine();
            assertEquals("Hello, World!", content);
        }
    }
}
