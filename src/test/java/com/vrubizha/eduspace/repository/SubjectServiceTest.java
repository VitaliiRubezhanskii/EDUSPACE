package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.support.SubjectBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@DataJpaTest
public class SubjectServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;



    @Before
    public void setUp(){

        SubjectBuilder subjectBuilder=new SubjectBuilder();
        Subject newCreatedWorking= subjectBuilder.subjectId(16).subjectName("Working").build();
        Subject algebra=subjectBuilder.subjectId(1).subjectName("Algebra").build();
    }


    @Test
    public void shoud_find_by_name_of_subject(){



    }







}
