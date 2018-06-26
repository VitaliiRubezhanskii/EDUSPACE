package com.vrubizha.eduspace;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EduspaceApplication {





    public static void main(String[] args) {
        SpringApplication.run(EduspaceApplication.class, args);

    }


}
