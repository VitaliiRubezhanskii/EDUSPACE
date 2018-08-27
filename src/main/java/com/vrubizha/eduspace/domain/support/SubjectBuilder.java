package com.vrubizha.eduspace.domain.support;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import org.springframework.stereotype.Component;

import java.util.Set;


public class SubjectBuilder {

    private Subject subject=new Subject();

//    public void initSubject(){
//        subject=new Subject();
//    }

    public SubjectBuilder subjectId(int subjectId){
        subject.setSubjectId(subjectId);
        return this;
    }

    public SubjectBuilder  subjectName(String subjectName){
        subject.setSubjectName(subjectName);
        return this;
    }

    public SubjectBuilder teachers(Set<Teacher> teachers){
        subject.setTeachers(teachers);
        return this;
    }

    public Subject build(){
        return subject;
    }


}
