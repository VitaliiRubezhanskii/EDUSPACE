package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SubjectController {

    private static final Logger logger=LoggerFactory.getLogger(SubjectController.class);
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectService.findAllSubjects();
    }

    @GetMapping("/subjects/{name}")
    public Subject findSubjectByName(@PathVariable("name") String name){
       return subjectService.findSubjectByName(name);
    }

    @GetMapping("/subjects/{id}")
    public Subject findSubjectByName(@PathVariable("id") int id){
        return subjectService.findSubjectById(id);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @DeleteMapping("/subjects")
    public Subject deleteSubject(@RequestBody Subject subject){
        return subjectService.deleteSubject(subject);
    }
}
