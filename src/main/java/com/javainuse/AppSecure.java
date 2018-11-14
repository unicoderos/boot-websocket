package com.javainuse;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class AppSecure{


    public static void main(String[] args) {

        ConfigurableApplicationContext run = run(AppSecure.class);

    }

}