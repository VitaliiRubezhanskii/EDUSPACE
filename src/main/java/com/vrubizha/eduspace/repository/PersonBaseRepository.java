package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonBaseRepository<T extends  Person> extends CrudRepository<T, Integer> {

    Person findPersonByEmail(String email);
}
