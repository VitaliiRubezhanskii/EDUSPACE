package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eduspace")
public class TeacherController {

    private  final TeacherService teacherService;
    private static  final Logger logger=LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity< Teacher > findTeacherById(@PathVariable("id") int id){
         logger.info("retrieving teacher with id= "+id);
         return new ResponseEntity<>(teacherService.findTeacherById(id),HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity< Teacher > createTeacher(@RequestBody Teacher teacher){
        Teacher createdTeacher=teacherService.createTeacher(teacher);
        logger.info("creating new teacher with id= "+createdTeacher.getPersonId());
    return  new ResponseEntity<>(createdTeacher,HttpStatus.OK);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity< Teacher > deleteTeacher(@RequestBody Teacher teacher){
        logger.info("deleting teacher with id= "+teacher.getPersonId());
    return new ResponseEntity<>(teacherService.deleteTeacher(teacher),HttpStatus.OK);
    }
}
