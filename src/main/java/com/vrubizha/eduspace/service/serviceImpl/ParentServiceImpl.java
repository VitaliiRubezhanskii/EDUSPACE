package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.repository.ParentRepository;
import com.vrubizha.eduspace.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {


    private ParentRepository parentRepository;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent delete(Parent parent) {
        parentRepository.delete(parent);
        return parent;
    }
}
