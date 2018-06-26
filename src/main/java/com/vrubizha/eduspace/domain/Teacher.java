package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
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
    @Column(name = "start_of_career")
    private Date startOfCareer;

    @Column(name = "professional_interest")
    private String professionalInterest;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private Set<Student>students;

    public Teacher() {
    }

    public Teacher(int personId, @Size(min = 1, max = 20) @NotNull String firstName, @Size(min = 1, max = 20) @NotNull String nameByFather,
                   @Size(min = 1, max = 20) @NotNull String lastName, @Email String email, Date startOfCareer, String professionalInterest) {
        this.personId=personId;
        this.firstName = firstName;
        this.nameByFather = nameByFather;
        this.lastName = lastName;
        this.email = email;
        this.startOfCareer = startOfCareer;
        this.professionalInterest = professionalInterest;
    }
}
