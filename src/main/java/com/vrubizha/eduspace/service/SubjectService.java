package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;

import java.util.List;

public interface SubjectService {

    Subject createSubject(Subject subject);
    void deleteSubject(int subjectId);
    Subject findSubjectById(int id);
    List<Subject> findAllSubjects();
    Subject findSubjectByName(String nameOfSubject);

}
