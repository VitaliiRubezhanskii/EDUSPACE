package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.ParentService;
import com.vrubizha.eduspace.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/eduspace")
@Slf4j
public class StudentController {

    private static final Logger logger=LoggerFactory.getLogger(StudentController.class);
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
        logger.info("teachers "+studentService.findStudentById(id).getTeachers());
        return studentService.findStudentById(id);
    }
}
