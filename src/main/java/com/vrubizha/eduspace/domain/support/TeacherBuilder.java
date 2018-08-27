package com.vrubizha.eduspace.domain.support;

import com.vrubizha.eduspace.domain.Teacher;

public class TeacherBuilder {

    private Teacher teacher;

    public void initTeacher(){
        teacher=new Teacher();
    }


    public TeacherBuilder teacherId(int id){
        teacher.setPersonId(id);
        return this;


    }


}
