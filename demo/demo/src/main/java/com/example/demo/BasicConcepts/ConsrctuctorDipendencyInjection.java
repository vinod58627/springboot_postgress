package com.example.demo.BasicConcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsrctuctorDipendencyInjection {
    private final Engine engine;

    @Autowired
    public ConsrctuctorDipendencyInjection(Engine engine) {
        this.engine = engine;
    }
    public void doSomething() {
        engine.start();
    }
}
