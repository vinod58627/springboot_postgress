package com.example.demo;

import com.example.demo.BasicConcepts.AppConfig;
import com.example.demo.BasicConcepts.BeanVsComponent;
import com.example.demo.BasicConcepts.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        System.out.println("Hello World");
    }


//public class DemoApplication implements CommandLineRunner {
//    @Autowired
//    public BeanVsComponent beanVsComponent;

//    public static void main(String[] args) {
//
//

    /// /        SpringApplication.run(DemoApplication.class, args);
    /// /        System.out.println("Start");
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Car car = context.getBean(Car.class);
//        car.drive();
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Hello this is Demo Application");
//    }

//    public void getNews() {
//        beanVsComponent.display();
//    }

}
