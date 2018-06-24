package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Student;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends PersonBaseRepository<Student> {


}
