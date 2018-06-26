package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.repository.StudentRepository;
import com.vrubizha.eduspace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(int id) {
        Optional<Student>studentOptional=studentRepository.findById(id);
        Student student=null;
        if (studentOptional.isPresent()){
            student=studentOptional.get();
        }
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public Student delete(Student student) {
        studentRepository.delete(student);
        return student;
    }
}

