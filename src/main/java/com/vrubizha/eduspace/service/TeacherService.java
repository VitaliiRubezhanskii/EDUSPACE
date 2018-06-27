package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.domain.Teacher;

public interface TeacherService {

    Teacher findTeacherById(int id);
    Teacher createTeacher(Teacher teacher);
    Teacher deleteTeacher(Teacher teacher);
//    Teacher findTeacherByStudents();

}
