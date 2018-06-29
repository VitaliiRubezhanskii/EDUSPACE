package com.vrubizha.eduspace.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vrubizha.eduspace"))
                .paths(any())
                .build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("EDUSPACE")
                .description("EDUSPACE - education and software development services")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Vitalii Rubezhanskii",
                        "https://springframework.guru/about/",
                        "vitalii.rubezhanskii@gmail.com"))
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

//    @Bean
//    public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
//        MappingJackson2HttpMessageConverter messageConverter = new  MappingJackson2HttpMessageConverter();
//
//        ObjectMapper mapper = new ObjectMapper();
//        //Registering Hibernate4Module to support lazy objects
//        mapper.registerModule(new Hibernate4Module());
//
//        messageConverter.setObjectMapper(mapper);
//        return messageConverter;
//
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //Here we add our custom-configured HttpMessageConverter
//        converters.add(jacksonMessageConverter());
//        super.configureMessageConverters(converters);
//    }
}

