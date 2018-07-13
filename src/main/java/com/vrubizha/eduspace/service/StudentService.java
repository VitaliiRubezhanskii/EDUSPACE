package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.domain.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    void delete(int student);
    Student findStudentById(int id);
    List<Student> findAllStudents();
    Student findStudentByEmail(String email);

}
