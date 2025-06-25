package io.github.pavelixo.controller;

import io.github.pavelixo.annotation.Controller;

@Controller
public class FakeController implements Router {
    public static boolean registered = false;

    @Override
    public void register() {
        registered = true;
    }
}
