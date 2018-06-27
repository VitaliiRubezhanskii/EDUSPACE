package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity< List<Subject> > getAllSubjects(){
        logger.info("retrieving all subjects from DB");
        return new ResponseEntity<>(subjectService.findAllSubjects(),HttpStatus.OK);
    }

    @GetMapping("/subjects/{name}")
    public ResponseEntity< Subject > findSubjectByName(@PathVariable("name") String name){
        logger.info("retrieving subject by name = "+name);
        return new ResponseEntity<>(subjectService.findSubjectByName(name),HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity< Subject > findSubjectById(@PathVariable("id") int id){
        logger.info("retrieving subject by id = "+id);
        return new ResponseEntity<>(subjectService.findSubjectById(id),HttpStatus.OK);
    }

    @PostMapping("/subjects")
    public ResponseEntity< Subject > createSubject(@RequestBody Subject subject){
        Subject createdSubject=subjectService.createSubject(subject);
        logger.info("created new subject with id = "+createdSubject.getSubjectId());
        return new ResponseEntity<>(createdSubject,HttpStatus.OK);
    }

    @DeleteMapping("/subjects")
    public ResponseEntity< Subject > deleteSubject(@RequestBody Subject subject){
        Subject deletedSubject=subjectService.deleteSubject(subject);
        logger.info("deleting subject with id = "+deletedSubject.getSubjectId());
        return new ResponseEntity<>(deletedSubject,HttpStatus.OK);
    }
}
