package com.vrubizha.eduspace.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@Inheritance
@DiscriminatorColumn(name = "person_type",
    discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public  class Person {

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


}
