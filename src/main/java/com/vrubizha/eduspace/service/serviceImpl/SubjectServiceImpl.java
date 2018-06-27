package com.vrubizha.eduspace.service.serviceImpl;


import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.repository.SubjectRepository;
import com.vrubizha.eduspace.repository.TeacherRepository;
import com.vrubizha.eduspace.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {


    private SubjectRepository subjectRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
        return subject;
    }

    @Override
    public Subject findSubjectById(int id) {
        Optional<Subject> subjectOptional=subjectRepository.findById(id);
        return subjectOptional.get();
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectByName(String nameOfSubject) {
          return subjectRepository.findSubjectByName(nameOfSubject);

    }
}
