package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Person;
import com.vrubizha.eduspace.repository.PersonBaseRepository;
import com.vrubizha.eduspace.repository.PersonRepository;
import com.vrubizha.eduspace.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}
