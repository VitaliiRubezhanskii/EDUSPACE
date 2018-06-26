package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.ParentService;
import com.vrubizha.eduspace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/eduspace")
public class StudentController {

    private final StudentService studentService;
    private final ParentService parentService;

    @Autowired
    public StudentController(StudentService studentService, ParentService parentService) {
        this.studentService = studentService;
        this.parentService = parentService;
    }


    @PostMapping(value = "/students",produces = "application/json",
            consumes = "application/json")
    public Student createStudent(@RequestBody Student student){ //
//        Parent father=new Parent(1,"Sergey","Ivanovich","Rubezhanskii", "sergey@gmail.com");
//        Parent mother=new Parent(2,"Larisa","Alexeevna","Rubezhanskaya","larisa@gmail.com");
//        Teacher teacher1=new Teacher(1,"Nina","Volodymyrivna","Rubezhanskaya", "nina@gmail.com",new Date(),"Physics");
//        Teacher teacher2=new Teacher(1,"Nina","Volodymyrivna","Rubezhanskaya", "nina@gmail.com",new Date(),"Physics");
//        Set<Parent> parents=new HashSet<>(Arrays.asList(father,mother));
//        Set<Teacher> teachers=new HashSet<>(Arrays.asList(teacher1,teacher2));
//        Student student=new Student(5,"Vitalii","Sergeevich","Rubezhanskii",
//        "vitalii@gmail.com",11,"Mathematics",parents,teachers);
        return studentService.save(student);
    }


    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.findStudentById(id);
    }
}
