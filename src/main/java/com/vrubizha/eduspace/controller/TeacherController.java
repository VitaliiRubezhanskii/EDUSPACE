package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    logger.info("students of this teacher: "+teacherService.findTeacherById(id));
    return teacherService.findTeacherById(id);

    }
}
