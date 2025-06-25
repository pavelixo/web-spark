package io.github.pavelixo.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import io.github.pavelixo.annotation.Controller;

public class Controllers {
    private static final String PACKAGE = "io.github.pavelixo.controller";
    private static final Reflections reflections = getReflections();
    
    public static void init() throws Exception {
        List<Router> controllers = getControllers();
        controllers.forEach(controller -> controller.register());
    }

    private static Set<Class<?>> getReflectedControllers() {
        return reflections.getTypesAnnotatedWith(Controller.class);
    }

    private static List<Router> getControllers() throws Exception  {
        List<Router> controllers = new ArrayList<>();
        for (Class<?> controller : getReflectedControllers()) {
            controllers.add(
                (Router) controller.getDeclaredConstructor().newInstance()
            );
        }
        return controllers;
    }

    private static Reflections getReflections() {
        return new Reflections(PACKAGE);
    }
}