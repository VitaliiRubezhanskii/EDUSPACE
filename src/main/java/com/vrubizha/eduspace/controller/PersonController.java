package com.vrubizha.eduspace.controller;


import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.domain.Person;
import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.domain.Teacher;
import com.vrubizha.eduspace.repository.ParentRepository;
import com.vrubizha.eduspace.repository.PersonRepository;
import com.vrubizha.eduspace.repository.StudentRepository;
import com.vrubizha.eduspace.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
public class PersonController {

    Teacher teacher=new Teacher(7,"Nadezhda","Ivanovna","Khrustovska","teacher@mail.ru","Chemics",null);
    Student student=new Student(5,"Vitalii","Sergeevich","Rubezhnskii","teacher@mail.ru",11,"Mathematics",2,4);


    private static final Logger logger=LoggerFactory.getLogger(PersonController.class);


    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ParentRepository parentRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, StudentRepository studentRepository,
                            TeacherRepository teacherRepository, ParentRepository parentRepository) {
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.parentRepository = parentRepository;
    }

    @GetMapping(value = "/people")
    public  Iterable<Person>getPeople(){
        logger.info("-- retrieving all people -- ");
        return personRepository.findAll();
    }


    @PostMapping(value = "/people/students",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Person saveStudent(@RequestBody Student student){
        logger.info("-- saving "+student.getFirstName()+" "+student.getLastName());
        personRepository.save(student);
        return student;
    }

    @PostMapping(value = "/people/teachers",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Teacher saveTeacher(@RequestBody Teacher teacher){
        logger.info("-- saving "+teacher.getFirstName()+" "+teacher.getLastName());
        personRepository.save(teacher);
        return teacher;
    }


    @PostMapping(value = "/people/parents",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Person saveParent(@RequestBody Parent parent){
        logger.info("-- saving "+parent.getFirstName()+" "+parent.getLastName());
        personRepository.save(parent);
        return parent;
    }



    @GetMapping(value = "/people/{email}")
    public Person findPersonByEmail(@PathVariable("email") String email){
        return personRepository.findPersonByEmail(email);

    }









}
