package com.vrubizha.eduspace.dto;

import com.vrubizha.eduspace.domain.Parent;
import com.vrubizha.eduspace.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentParentDto {

   private Student student;
   private Parent parent;

}
