package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.ParentService;
import com.vrubizha.eduspace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/eduspace")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students",produces = "application/json",
            consumes = "application/json")
    public Student createStudent(@RequestBody Student student){ //
        return studentService.save(student);
    }


    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.findStudentById(id);
    }
}
