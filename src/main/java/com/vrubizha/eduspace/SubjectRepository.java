package com.vrubizha.eduspace;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {


    Subject findSubjectBySubjectName(String name);


}
