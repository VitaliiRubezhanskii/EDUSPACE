package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.domain.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    Student delete(Student student);
    Student findStudentById(int id);
    List<Student> findAllStudents();

}
