package com.vrubizha.eduspace.repository;


import com.vrubizha.eduspace.EduspaceApplication;
import com.vrubizha.eduspace.StudentRepository;
import com.vrubizha.eduspace.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigInteger;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = EduspaceApplication.class)
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;


    private Student studentFirst;
    private Student studentSecond;
    private Student studentThird;
    private Parent parentFirst;
    private Parent parentSecond;
    private Address addressOne;
    private Address addressTwo;
    private Account accountStudentFirst;
    private Account accountStudentSecond;
    private Account accountParentOfFirstStudent1;
    private Account accountParentOfFirstStudent2;
    private Account accountParentOfSecondStudent1;
    private Account accountParentOfSecondStudent2;
    private Account accountTeacher1;
    private Account accountTeacher2;
    private Teacher teacher1;
    private  Teacher teacher2;
    private Group groupOne;
    private Group groupTwo;
    private Subject algebra;
    private Subject ukranian;


    @Before
    public void setUp(){
        Set<Student> students=new HashSet<>(Arrays.asList(studentFirst,studentSecond));
        Set<Group> groups=new HashSet<>(Arrays.asList(groupOne,groupTwo));

     Parent parentOfFirstStudent1=new Parent(2,"Sergey","Ivanovich","Rubezhanskii","sergey.rubezhanskii@gmail.com",
             new HashSet<>(Arrays.asList(studentFirst)),accountParentOfFirstStudent1);
     Parent parentOfFirstStudent2=new Parent(3,"Larisa","Alexeevna","Rubezhanskaya","larisa.rubezhanskaya@gmail.com",
             new HashSet<>(Arrays.asList(studentFirst)),accountParentOfFirstStudent2);
     Parent parentOfSecondStudent1=new Parent(4,"Evgen","Ivanovich","Sobenko","evgen.sobenko@gmail.com",
                new HashSet<>(Arrays.asList(studentSecond)),accountParentOfSecondStudent1);
     Parent parentOfSecondStudent2=new Parent(5,"Elena","Alexandrovna","Sobenko","elena.sobenko@gmail.com",
                new HashSet<>(Arrays.asList(studentSecond)),accountParentOfSecondStudent2);

     algebra=new Subject(1,"Algebra",new HashSet<>(Arrays.asList(teacher1)));
     ukranian=new Subject(2,"Ukrainian",new HashSet<>(Arrays.asList(teacher2)));

    Set<Parent>studentOneParents=new HashSet<>(Arrays.asList(parentOfFirstStudent1,parentOfFirstStudent2));
    Set<Parent>studentTwoParents=new HashSet<>(Arrays.asList(parentOfSecondStudent1,parentOfSecondStudent2));

    accountStudentFirst=new Account(1,21345,"PRO","ACTIVE",10,
            new BigInteger("500"),studentFirst,null,null,null);
    accountStudentSecond=new Account(2,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,null,null,null);
    accountParentOfFirstStudent1=new Account(3,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),null,parentOfFirstStudent1,null,null);
    accountParentOfFirstStudent2=new Account(4,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,parentOfFirstStudent2,null,null);
    accountParentOfSecondStudent1=new Account(5,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,parentOfSecondStudent1,null,null);
    accountParentOfSecondStudent2=new Account(6,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,parentOfSecondStudent2,null,null);
    accountTeacher1=new Account(7,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,null,teacher1,null);
    accountTeacher2=new Account(8,21345,"PRO","ACTIVE",10,
                new BigInteger("500"),studentSecond,null,teacher2,null);

    teacher1=new Teacher(1,"Alexander","Leonidovich","Melnikov","alex.melnikov@gmail.com",new Date(),"Teaching of talents in math",
            students,new HashSet<>(Arrays.asList(algebra)),accountTeacher1);
    teacher2=new Teacher(2,"Lydmila","Mykolayivna","Keleberda","lyudmila.keleberda@gmail.com",new Date(),"Teaching of talents in philology",
                students,new HashSet<>(Arrays.asList(ukranian)),accountTeacher2);

    Set<Teacher>teachers=new HashSet<>(Arrays.asList(teacher1,teacher2));

    groupOne=new Group(1,"groupNameOne","groupInfoOne",students);
    groupTwo=new Group(2,"groupNameTwo","groupInfoTwo",students);

    studentFirst=new Student(1,"Vitalii","Sergeevich","Rubezhanskii","vitalii.rubezhanskii@gmail.com",
            11,"+380502788594","Mathematics",addressOne,
           studentOneParents,teachers,groups, accountStudentFirst);
    studentThird=new Student("Vitalii","Sergeevich","Rubezhanskii","vitalii.rubezhanskii@gmail.com",
                11,"380502788594","Mathematics" );
    studentThird.setAddress(new Address());
    studentSecond=new Student(2,"Vladislav","Yevgeniyevich","Sobenko",
                "vladislav.sobenko@gmail.com",11,"+380502788595","Mathematics",
                addressTwo,studentTwoParents,teachers,groups, accountStudentSecond);

    addressOne=new Address(1,"Ukraine","Kharkiv obl","Velyky Burluk",
            "VelykoBurlutsky","Vesnyana","612345",new HashSet<Student>(Arrays.asList(studentFirst)));
    addressTwo=new Address(2,"Ukraine","Kharkiv obl","Velyky Burluk",
                "VelykoBurlutsky","MicroRegion","627000",new HashSet<Student>(Arrays.asList(studentSecond)));

    }

    @Test
    public void testSaveNewStudent() throws  Exception{
       Student savedStudent=studentRepository.save(studentThird);

        assertThat(savedStudent.getFirstName()).isEqualTo(studentThird.getFirstName());
        assertThat(savedStudent.getNameByFather()).isEqualTo(studentThird.getNameByFather());
        assertThat(savedStudent.getLastName()).isEqualTo(studentThird.getLastName());
        assertThat(savedStudent.getAccount()).isEqualTo(studentThird.getAccount());

    }

    @Test
    public void  testFindStudentById() throws Exception{

        Student savedStudent=testEntityManager.persist(studentThird);
        Student foundStudent=studentRepository.findById(savedStudent.getPersonId()).get();
        assertThat(foundStudent.getFirstName()).isEqualTo(savedStudent.getFirstName());
        assertThat(foundStudent.getNameByFather()).isEqualTo(savedStudent.getNameByFather());
        assertThat(foundStudent.getLastName()).isEqualTo(savedStudent.getLastName());
        assertThat(foundStudent.getAccount()).isEqualTo(savedStudent.getAccount());
    }

    @Test
    public void testFindStudentByEmail() throws Exception{

        Student savedStudent= testEntityManager.merge(studentThird);
        Student foundStudent=studentRepository.findStudentByEmail("vitalii.rubezhanskii@gmail.com");
        assertThat(foundStudent.getFirstName()).isEqualTo(savedStudent.getFirstName());
        assertThat(foundStudent.getNameByFather()).isEqualTo(savedStudent.getNameByFather());
        assertThat(foundStudent.getLastName()).isEqualTo(savedStudent.getLastName());
        assertThat(foundStudent.getAccount()).isEqualTo(savedStudent.getAccount());

    }
    @Test
    public void testDindAllStudents() throws Exception{

        List<Student> savedStudents=Arrays.asList(studentThird,studentThird,studentThird);
        savedStudents.forEach(student -> testEntityManager.merge(student));

        List<Student> foundAllStudents=studentRepository.findAll();
        assertThat(foundAllStudents.size()).isEqualTo(savedStudents.size());
        assertThat(foundAllStudents.get(1).getNameByFather()).isEqualTo(savedStudents.get(1).getNameByFather());
    }

    @Test
    public void testDeleteStudentById() throws Exception{


        Student savedStudent=testEntityManager.persist(studentThird);
        studentRepository.deleteById(savedStudent.getPersonId());
        Student foundAfterDeletion=testEntityManager.find(Student.class,1);
        assertThat(foundAfterDeletion).isNull();

    }

    @After
    public void tearDown() throws Exception{
        testEntityManager.clear();
    }

}
