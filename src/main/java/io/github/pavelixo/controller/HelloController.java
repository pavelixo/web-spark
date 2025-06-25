package io.github.pavelixo.controller;

import io.github.pavelixo.annotation.Controller;
import io.github.pavelixo.core.Router;
import static spark.Spark.get;

@Controller
public class HelloController implements Router {
    @Override
    public void register() {
        get("/hello", (request, response) -> {
            return "Hello, World!";
        });
    }
}
