package com.vrubizha.eduspace.repository;


import com.vrubizha.eduspace.EduspaceApplication;
import com.vrubizha.eduspace.SubjectRepository;
import com.vrubizha.eduspace.domain.Subject;
import com.vrubizha.eduspace.domain.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = EduspaceApplication.class)
public class SubjectRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SubjectRepository subjectRepository;

    private Subject subject1 = new Subject();
    private Subject subject2 = new Subject();
    private Teacher teacher1 = new Teacher();
    private Teacher teacher2 = new Teacher();
    private Set<Teacher> teachers;

    /**
     *  setup test data
     */

    @Before
    public void setUp(){

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

    /**
     *  test saving new subject to database
     */
    @Test
    public void should_save_new_subject() {
        Subject savedSubject = subjectRepository.save(subject1);

        assertThat(savedSubject).isNotNull();
        assertThat(savedSubject.getSubjectName()).isEqualTo("TestSubject");
        assertThat(savedSubject.getTeachers()).isEqualTo(teachers);
    }

    /**
     * test method find subject by its name
     */
    @Test
    public void should_find_subject_by_name(){
      Subject persistedSubject=testEntityManager.persist(subject1);
      Subject foundSubject=subjectRepository.findSubjectBySubjectName("TestSubject");

      assertThat(persistedSubject.getSubjectName()).isEqualTo(foundSubject.getSubjectName());
      assertThat(persistedSubject.getTeachers()).isEqualTo(foundSubject.getTeachers());
    }

    /**
     * test if NullPointerException is thrown when subjectName = null
     */

    @Test(expected = NullPointerException.class)
    public void should_throw_NullPointerException(){

        Subject persistedSubject=testEntityManager.persist(subject1);
        Subject foundSubject=subjectRepository.findSubjectBySubjectName(null);

        assertThat(persistedSubject.getSubjectName()).isEqualTo(foundSubject.getSubjectName());
        assertThat(persistedSubject.getTeachers()).isEqualTo(foundSubject.getTeachers());
    }

    /**
     * test if all persisted subjects are retrived by findAll method
     */

    @Test
    public void should_find_all_persisted_subjects(){
      Subject persistedSubject1=  testEntityManager.persist(subject1);
        Subject persistedSubject2= testEntityManager.persist(subject2);

        List<Subject>persistedSubjects=Arrays.asList(persistedSubject1,persistedSubject2);
        List<Subject> foundSubjects=subjectRepository.findAll();

        assertThat(foundSubjects).isEqualTo(persistedSubjects);

    }

    /**
     * test delete method for subjects
     */

    @Test
    public void delete_subject_should_return_deleted_subject(){
        Subject persistedSubject1=  testEntityManager.persist(subject1);
        Subject persistedSubject2= testEntityManager.persist(subject2);

        subjectRepository.delete(subject1);
        assertThat(Arrays.asList(subject2)).isEqualTo(subjectRepository.findAll());

    }

    /**
     * tear out data from test database
     */

    @After
    public void tearDown(){
        testEntityManager.clear();

    }


    }
