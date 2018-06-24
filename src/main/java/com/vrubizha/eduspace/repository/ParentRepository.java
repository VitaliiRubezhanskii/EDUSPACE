package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Parent;

import javax.transaction.Transactional;

@Transactional
public interface ParentRepository extends PersonBaseRepository<Parent> {

}
