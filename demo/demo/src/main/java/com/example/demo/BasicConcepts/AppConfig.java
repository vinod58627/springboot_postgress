package com.example.demo.BasicConcepts;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }
    @Bean
    //use model mapper to convert dto to entity and vise versa.
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Car car() {
        return new Car(engine());
    }

}
