package com.example.demo.BasicConcepts;

import com.example.demo.config.CustomInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@EnableJpaAuditing
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private CustomInterceptor customInterceptor;

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


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor).addPathPatterns("/**");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${project.base.url}")
    private String BASE_URL;

    @Bean
    @Qualifier("projectRestClient")
    RestClient getRestClient() {
        return RestClient.builder().baseUrl(BASE_URL).defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE).build();
    }

}
