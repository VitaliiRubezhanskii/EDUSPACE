package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "parent")
@Data
@AllArgsConstructor
public class Parent implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parent_id")
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "parents")
    private Set<Student> students;



    public Parent() {
    }

    public Parent(int personId, @Size(min = 1, max = 20) @NotNull String firstName, @Size(min = 1, max = 20) @NotNull String nameByFather,
                  @Size(min = 1, max = 20) @NotNull String lastName, @Email String email) {
        this.personId=personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
    }
}
