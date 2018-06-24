package com.vrubizha.eduspace.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "teacher")
@DiscriminatorValue("teacher")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Teacher extends Person {

    @Column(name = "start_of_career")
    private Date startOfCareer;

    @Column(name = "professional_interest")
    private String professionalInterest;

    public Teacher(int id,String first_name,String name_by_father,
                   String last_name,String email,String professionalInterest,Date startOfCareer){
        super(id,first_name,name_by_father,last_name,email);
        this.setProfessionalInterest(professionalInterest);
        this.setStartOfCareer(startOfCareer);
    }


}
