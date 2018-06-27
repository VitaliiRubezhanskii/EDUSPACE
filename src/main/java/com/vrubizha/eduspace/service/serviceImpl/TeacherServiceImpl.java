package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.exception.TeacherNotFoundException;
import com.vrubizha.eduspace.repository.TeacherRepository;
import com.vrubizha.eduspace.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger=LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher=teacherRepository.findById(id).get();
        logger.info("students "+teacher.getStudents());
        if (teacher!=null){
        return  teacher;
        }else throw new TeacherNotFoundException("There are no student with "+id+ " in the database");

    }

//    @Override
//    public Teacher findTeacherByStudents() {
//        return teacherRepository.findTeacherByStudents();
//    }
}
