package com.vrubizha.eduspace;


import com.vrubizha.eduspace.configuration.SwaggerConfiguration;
import com.vrubizha.eduspace.configuration.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import({WebMvcConfiguration.class,
        SwaggerConfiguration.class})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EduspaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduspaceApplication.class, args);

    }


}
