package com.vrubizha.eduspace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
@Data

@JsonIgnoreProperties({"teachers,parents"})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int personId;

    @Column(name = "first_name")
    @Size(min = 1, max = 20)
    @NotNull
    private String firstName;

    @Column(name = "name_by_father")
    @Size(min = 1, max = 20)
    @NotNull
    private String nameByFather;

    @Column(name = "last_name")
    @Size(min = 1, max = 20)
    @NotNull
    private String lastName;

    @Column(name="email")
    @Email
    private  String email;

    @Column(name = "grade")
    @NotNull
    @Max(12)
    private int grade;
    @Column(name = "studying_interest")
    private String studyingInterest;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "parent_id",
                    nullable = false, updatable = false) })
    @JsonIgnoreProperties("students")
    private Set<Parent> parents;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_teacher", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id",
                    nullable = false, updatable = false) })
    @JsonIgnoreProperties("students")
    private Set<Teacher>teachers;

    public Student() {
    }

    public Student(int personId, @Size(min = 1, max = 20) @NotNull String firstName, @Size(min = 1, max = 20) @NotNull String nameByFather, @Size(min = 1, max = 20) @NotNull String lastName,
                   @Email String email, @NotNull @Max(12) int grade, String studyingInterest, Set<Parent> parents, Set<Teacher> teachers) {
        this.personId=personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.studyingInterest = studyingInterest;
        this.parents = parents;
        this.teachers = teachers;
    }
}
