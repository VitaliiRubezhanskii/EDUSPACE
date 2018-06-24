package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Person;
import javax.transaction.Transactional;

@Transactional
public interface PersonRepository  extends PersonBaseRepository<Person> {

}
