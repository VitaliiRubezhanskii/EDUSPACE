package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Teacher findTeacherById(@PathVariable("id") int id){
    logger.info("retrieving teacher with id= "+id);
    return teacherService.findTeacherById(id);
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        Teacher createdTeacher=teacherService.createTeacher(teacher);
        logger.info("creating new teacher with id= "+createdTeacher.getPersonId());
    return  createdTeacher;
    }

    @DeleteMapping("/teachers/{id}")
    public Teacher deleteTeacher(@RequestBody Teacher teacher){
    return teacherService.deleteTeacher(teacher);
    }
}
