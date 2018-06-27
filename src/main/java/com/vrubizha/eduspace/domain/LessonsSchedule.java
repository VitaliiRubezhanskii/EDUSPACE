package com.vrubizha.eduspace.domain;

import com.vrubizha.eduspace.domain.embeddables.LessonScheduleId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class LessonsSchedule {


    private LessonScheduleId lessonScheduleId;
    private String classGroup;
    private int subjectId;

    public LessonsSchedule() {
    }

    public LessonsSchedule(LessonScheduleId lessonScheduleId, String classGroup, int subjectId) {
        this.lessonScheduleId = lessonScheduleId;
        this.classGroup = classGroup;
        this.subjectId = subjectId;
    }

    @EmbeddedId
    public LessonScheduleId getLessonScheduleId() {
        return lessonScheduleId;
    }
    public void setLessonScheduleId(LessonScheduleId lessonScheduleId) {
        this.lessonScheduleId = lessonScheduleId;
    }

    @Column(name = "class_group")
    public String getClassGroup() {
        return classGroup;
    }
    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    @Column(name = "subject_id")
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
