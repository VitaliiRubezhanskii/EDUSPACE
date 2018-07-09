package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.SubjectRepository;
import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.serviceImpl.SubjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepositoryMock;

    @Mock
    private Subject subject1;
    @Mock
    private Subject subject2;


    private SubjectServiceImpl subjectService;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        subjectService=new SubjectServiceImpl(subjectRepositoryMock);
    }

    /**
     *  test create new subject method
     */

    @Test
    public void should_save_new_subject_and_return_it(){
        when(subjectRepositoryMock.save(subject1)).thenReturn(subject1);

        assertThat(subjectService.createSubject(subject1)).isEqualTo(subject1);
    }

    /**
     *  test if findAllSubjects method works properly
     */

    @Test
    public void should_find_all_subjects(){

        List<Subject> testSubjects=Arrays.asList(subject1,subject2);
    when(subjectRepositoryMock.findAll()).thenReturn(testSubjects);
    assertThat(subjectService.findAllSubjects()).isEqualTo(testSubjects);

    }

    /**
     * test if findSubjectByName method works properly
     */
    @Test
    public void should_find_subject_by_name(){
        String subjectName=subject1.getSubjectName();
        when(subjectRepositoryMock.findSubjectBySubjectName(subjectName)).thenReturn(subject1);

        assertThat(subjectService.findSubjectByName(subject1.getSubjectName())).isEqualTo(subject1);

    }

    /**
     * test if findSubjectById method works properly
     */
    @Test
    public void should_find_subject_by_id(){

        subject1.setSubjectId(5);
        when(subjectRepositoryMock.findById(subject1.getSubjectId())).thenReturn(Optional.of(subject1));
        assertThat(subjectService.findSubjectById(subject1.getSubjectId())).isEqualTo(subject1);


    }


}
