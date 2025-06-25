package io.github.pavelixo.core;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import io.github.pavelixo.controller.FakeController;

public class ControllersTest {

    @AfterEach
    public void cleanup() {
        FakeController.registered = false;
    }

    @Test
    public void testInitShouldCallRegisterOnAnnotatedControllers() throws Exception {
        Controllers.init();
        assertTrue(FakeController.registered, "FakeController.register() was not called");
    }
}
