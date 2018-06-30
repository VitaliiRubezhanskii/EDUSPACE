package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {


    private int personId;

    @Size(min = 1, max = 20)
    @NotNull
    private String firstName;

    @Size(min = 1, max = 20)
    @NotNull
    private String nameByFather;

    @Size(min = 1, max = 20)
    @NotNull
    private String lastName;



    @Email
    private  String email;
    private Date startOfCareer;
    private String professionalInterest;
    private Set<Student>students;
    private Set<Subject> subjects;
    private Account account;

    public Teacher() {
    }

    public Teacher(int personId, @Size(min = 1, max = 20) @NotNull String firstName, @Size(min = 1, max = 20) @NotNull String nameByFather,
                   @Size(min = 1, max = 20) @NotNull String lastName, @Email String email, Date startOfCareer, String professionalInterest,
                   Set<Student> students, Set<Subject> subjects,Account account) {
        this.personId = personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
        this.startOfCareer = startOfCareer;
        this.professionalInterest = professionalInterest;
        this.students = students;
        this.subjects = subjects;
        this.account=account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "name_by_father")
    public String getNameByFather() {
        return nameByFather;
    }
    public void setNameByFather(String nameByFather) {
        this.nameByFather = nameByFather;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "start_of_career")
    public Date getStartOfCareer() {
        return startOfCareer;
    }
    public void setStartOfCareer(Date startOfCareer) {
        this.startOfCareer = startOfCareer;
    }

    @Column(name = "professional_interest")
    public String getProfessionalInterest() {
        return professionalInterest;
    }
    public void setProfessionalInterest(String professionalInterest) {
        this.professionalInterest = professionalInterest;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_subject", joinColumns = {
            @JoinColumn(name = "teacher_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "subject_id",
                    nullable = false, updatable = false) })
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = CascadeType.ALL)
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}

