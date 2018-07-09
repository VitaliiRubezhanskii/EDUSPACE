package com.vrubizha.eduspace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.BDDMockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SubjectService subjectServiceMock;

    private SubjectController subjectController;

    private JacksonTester<Subject> subjectJacksonTester;


    private Subject subject1 = new Subject();
    private Subject subject2 = new Subject();
    private Teacher teacher1 = new Teacher();
    private Teacher teacher2 = new Teacher();
    private Set<Teacher> teachers;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        subjectController=new SubjectController(subjectServiceMock);
        JacksonTester.initFields(this,new ObjectMapper());

        mockMvc=MockMvcBuilders.standaloneSetup(subjectController).build();

        teacher1.setFirstName("testFirstName1");
        teacher1.setLastName("testLastName1");
        teacher1.setEmail("testEmail@gmail1.com");

        teacher2.setFirstName("testFirstName2");
        teacher2.setLastName("testLastName2");
        teacher2.setEmail("testEmail@gmail2.com");

        teachers = new HashSet<>(Arrays.asList(teacher1, teacher2));

        subject1.setSubjectName("TestSubject");
        subject1.setTeachers(teachers);

        subject2.setSubjectName("TestSubject2");
        subject2.setTeachers(teachers);
    }

    @Test
    public void get_all_subjects_should_return_them() throws Exception{

        subject1.setSubjectId(5);

        given(subjectServiceMock.findSubjectById(subject1.getSubjectId())).willReturn(subject1);

        MockHttpServletResponse response=mockMvc.perform(
                get("/subjects/5")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(subjectJacksonTester.write(subject1).getJson());


//        given(superHeroRepository.getSuperHero(2))
//                .willReturn(new SuperHero("Rob", "Mannon", "RobotMan"));
//
//        // when
//        MockHttpServletResponse response = mvc.perform(
//                get("/superheroes/2")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
//        );

    }

}
