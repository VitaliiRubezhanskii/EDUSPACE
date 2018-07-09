package com.vrubizha.eduspace;

import com.vrubizha.eduspace.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentByEmail(String email);
}
