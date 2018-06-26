package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.exception.TeacherNotFoundException;
import com.vrubizha.eduspace.repository.TeacherRepository;
import com.vrubizha.eduspace.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher=teacherRepository.findById(id).get();

        if (teacher!=null){
        return  teacher;
        }else throw new TeacherNotFoundException("There are no student with "+id+ " in the database");

    }
}
