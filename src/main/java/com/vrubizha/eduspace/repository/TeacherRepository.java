package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Teacher;

import javax.transaction.Transactional;

@Transactional
public interface TeacherRepository extends PersonBaseRepository<Teacher> {
}
