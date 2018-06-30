package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student implements Serializable {

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
    @NotNull
    @Max(12)
    private int grade;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    private String studyingInterest;
    private Address address;
    private Set<Parent> parents;
    private Set<Teacher>teachers;
    private Set<Group> groups;

    public Student() {
    }

    public Student(int personId, @Size(min = 1, max = 20) @NotNull String firstName,
                   @Size(min = 1, max = 20) @NotNull String nameByFather, @Size(min = 1, max = 20) @NotNull String lastName,
                   @Email String email, @NotNull @Max(12) int grade, @Pattern(regexp = "(^$|[0-9]{10})") String phone,
                   String studyingInterest,
                   Address address, Set<Parent> parents, Set<Teacher> teachers, Set<Group> groups) {
        this.personId = personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.phone = phone;
        this.studyingInterest = studyingInterest;
        this.address = address;
        this.parents = parents;
        this.teachers = teachers;
        this.groups = groups;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
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

    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Column(name = "studying_interest")
    public String getStudyingInterest() {
        return studyingInterest;
    }
    public void setStudyingInterest(String studyingInterest) {
        this.studyingInterest = studyingInterest;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "parent_id",
                    nullable = false, updatable = false) })
    public Set<Parent> getParents() {
        return parents;
    }
    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_teacher", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id",
                    nullable = false, updatable = false) })
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }


    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }


    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "student_interestgroups", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "group_id",
                    nullable = false, updatable = false) })
    public Set<Group> getGroups() {
        return groups;
    }
    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
