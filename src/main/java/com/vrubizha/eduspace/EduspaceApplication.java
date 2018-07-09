package com.vrubizha.eduspace;


import com.vrubizha.eduspace.service.SubjectService;
import com.vrubizha.eduspace.service.serviceImpl.SubjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EduspaceApplication  {
    public static void main(String[] args) {
        SpringApplication.run(EduspaceApplication.class, args);

    }

//    @Bean
//    public SubjectService subjectService(){
//       return new SubjectServiceImpl();
//    }



}




