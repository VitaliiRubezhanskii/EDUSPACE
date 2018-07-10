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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.io.IOException;
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

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

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
    public void get_one_subject_should_return_it() throws Exception {

        subject1.setSubjectId(5);

        given(subjectServiceMock.findSubjectById(subject1.getSubjectId())).willReturn(subject1);

        MockHttpServletResponse response = this.mockMvc.perform(
                get("/subjects/5")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(subjectJacksonTester.write(subject1).getJson());
    }

    @Test
    public void get_all_subjects_should_return_them() throws Exception{
        List<Subject> subjects=Arrays.asList(subject1,subject2);
        given(subjectServiceMock.findAllSubjects()).willReturn(subjects);

       this.mockMvc.perform(
                get("/subjects")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].subjectName",is(subject1.getSubjectName())));


        }

        @Test
        public void should_save_subject_by_post_http_method() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        given(subjectServiceMock.createSubject(subject1)).willReturn(subject1);

        this.mockMvc.perform(post("/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json(subject1)))
                .andExpect(status().isCreated());


        }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }



}
