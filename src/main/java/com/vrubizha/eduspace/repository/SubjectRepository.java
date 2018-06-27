package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    @Query("select subject from Subject  subject where subject.subjectName=:subjectName")
    Subject findSubjectByName(@Param("subjectName") String nameOfSubject);


}
