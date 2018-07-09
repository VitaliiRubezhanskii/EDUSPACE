package com.vrubizha.eduspace;

import com.vrubizha.eduspace.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ParentRepository extends JpaRepository<Parent,Integer> {

}
