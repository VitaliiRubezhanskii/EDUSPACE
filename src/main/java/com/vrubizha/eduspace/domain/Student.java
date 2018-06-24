package com.vrubizha.eduspace.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
@DiscriminatorValue("student")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student extends Person {

    @Column(name = "grade")
    @NotNull
    @Max(12)
    private int grade;
    @Column(name = "studying_interest")
    private String studyingInterest;
    @Column(name = "father_id")
    private int fatherId;
    @Column(name = "mother_id")
    private int motherId;

    public Student(int id,String first_name,String name_by_father,
                   String last_name,String email,int grade,String studyingInterest,int fatherId,int motherId){
        super(id,first_name,name_by_father,last_name,email);
        this.setGrade(grade);
        this.setStudyingInterest(studyingInterest);
        this.setFatherId(fatherId);
        this.setMotherId(motherId);
    }
}
