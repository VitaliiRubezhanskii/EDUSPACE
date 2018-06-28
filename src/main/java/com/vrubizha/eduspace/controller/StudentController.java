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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


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

    @PostMapping(value = "/students",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity< Student > createStudent(@RequestBody Student student){
        Student createdStudent=studentService.save(student);
        logger.info("created new student with id= "+createdStudent.getPersonId());
        return new ResponseEntity<>(createdStudent,HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity< Student > getStudentById(@PathVariable("id") int id){
        logger.info("retrieving student with id= "+id);
        Student foundStudent=studentService.findStudentById(id);
        if (foundStudent==null)
            return new ResponseEntity<>(foundStudent,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(foundStudent,HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity< Student > deleteStudent(@RequestBody Student student){
        logger.info("deleting student with id= "+student.getPersonId());
        return new ResponseEntity<>(studentService.delete(student),HttpStatus.OK);
    }
}
