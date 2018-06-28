package com.vrubizha.eduspace;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EduspaceApplication  {
    public static void main(String[] args) {
        SpringApplication.run(EduspaceApplication.class, args);

    }

//    @Bean
//    public WebMvcConfigurer webMvcAutoConfiguration(){
//        return  new WebMvcConfigurerAdapter() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler(
//                        "/webjars/**",
//                        "/img/**",
//                        "/css/**",
//                        "/js/**")
//                        .addResourceLocations(
//                                "classpath:/META-INF/resources/webjars/",
//                                "classpath:/static/img/",
//                                "classpath:/static/css/",
//                                "classpath:/static/js/");
//
//
//
//    }
//        };
//    }
}




