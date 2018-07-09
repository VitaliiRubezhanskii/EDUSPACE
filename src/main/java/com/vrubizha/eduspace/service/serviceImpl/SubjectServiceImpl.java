package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.SubjectRepository;
import com.vrubizha.eduspace.TeacherRepository;
import com.vrubizha.eduspace.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {


    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
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
        return subjectRepository.findById(id).orElse(null);

    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectByName(String nameOfSubject) {
          return subjectRepository.findSubjectBySubjectName(nameOfSubject);

    }
}
