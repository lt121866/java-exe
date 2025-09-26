package com.liutai.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.liutai")
@SpringBootApplication
public class DemoNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNativeApplication.class);
    }
}
