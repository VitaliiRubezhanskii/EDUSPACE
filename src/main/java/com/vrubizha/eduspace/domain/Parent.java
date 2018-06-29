package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {

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

    private Set<Student> students;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parent_id")
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH}, mappedBy = "parents")
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Parent() {
    }



    public Parent(int personId, @Size(min = 1, max = 20) @NotNull String firstName, @Size(min = 1, max = 20) @NotNull String nameByFather,
                  @Size(min = 1, max = 20) @NotNull String lastName, @Email String email, Set<Student> students) {
        this.personId = personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return getPersonId() == parent.getPersonId() &&
                Objects.equals(getFirstName(), parent.getFirstName()) &&
                Objects.equals(getNameByFather(), parent.getNameByFather()) &&
                Objects.equals(getLastName(), parent.getLastName()) &&
                Objects.equals(getEmail(), parent.getEmail()) &&
                Objects.equals(getStudents(), parent.getStudents());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPersonId(), getFirstName(), getNameByFather(), getLastName(), getEmail(), getStudents());
    }
}
