package com.vrubizha.eduspace.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {

    private int subjectId;

    @NotNull
    @Size(min =1,max = 20)
    private  String subjectName;

    private Set<Teacher> teachers;

    public Subject() {
    }

    public Subject(int subjectId, @NotNull @Size(min = 1, max = 20) String subjectName, Set<Teacher> teachers) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teachers = teachers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name = "subject_name")
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
