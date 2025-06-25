package io.github.pavelixo;

import io.github.pavelixo.controller.Controllers;
import static spark.Spark.port;


public class App {
    public static void main(String[] args) throws Exception{
        port(8080);
        Controllers.init();
    }
}