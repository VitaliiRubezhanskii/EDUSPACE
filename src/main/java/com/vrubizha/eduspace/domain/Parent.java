package com.vrubizha.eduspace.domain;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
@DiscriminatorValue("parent")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Parent extends Person {



//public Parent(int id,String firstName,String nameByFather,String lastName){
//    super(id,firstName,nameByFather,lastName);
//}



}
