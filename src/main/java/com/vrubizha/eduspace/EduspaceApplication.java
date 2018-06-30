package com.vrubizha.eduspace;



import com.vrubizha.eduspace.configuration.rabbitMQ.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(RabbitConfiguration.class)
@ComponentScan(basePackages = {"com.vrubizha.eduspace"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EduspaceApplication  {
    public static void main(String[] args) {
        SpringApplication.run(EduspaceApplication.class, args);

    }


}




