package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherByPersonId(int personId);
//    Teacher findTeacherByStudents();
}
