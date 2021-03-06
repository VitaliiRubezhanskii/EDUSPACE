package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.exception.StudentNotFoundException;
import com.vrubizha.eduspace.StudentRepository;
import com.vrubizha.eduspace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

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
        } else throw new StudentNotFoundException("There are no student with "+id+" in the database");
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public void delete(int studentId) {
        studentRepository.deleteById(studentId);

    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }
}

