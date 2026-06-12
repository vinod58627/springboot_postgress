package com.example.demo.BasicConcepts;

public class ManualDependencyInjection {
    //Manual Dipendency Injection
    private Engine engine;

    public ManualDependencyInjection(){
        this.engine = new Engine();
    }
    public void doSomthing(){
        engine.start();
    }
}
