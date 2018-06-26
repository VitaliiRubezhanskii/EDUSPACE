package com.vrubizha.eduspace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Student {

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

    @Column(name = "grade")
    @NotNull
    @Max(12)
    private int grade;
    @Column(name = "studying_interest")
    private String studyingInterest;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "parent_id",
                    nullable = false, updatable = false) })
    private Set<Parent> parents;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_teacher", joinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id",
                    nullable = false, updatable = false) })
    private Set<Teacher>teachers;


}
