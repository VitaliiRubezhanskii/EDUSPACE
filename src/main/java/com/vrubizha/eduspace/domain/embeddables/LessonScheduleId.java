package com.vrubizha.eduspace.domain.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LessonScheduleId implements Serializable {

    @Column(name = "week_num")
    private  int weekNumber;

    @Column(name = "lesson_num")
    private int lessonNumber;

    @Column(name = "weekDayNum")
    private int weekDayNumber;

    @Column(name = "teacher_id")
    private int teacherId;

    public LessonScheduleId() {
    }

    public LessonScheduleId(int weekNumber, int lessonNumber, int weekDayNumber, int teacherId) {
        this.weekNumber = weekNumber;
        this.lessonNumber = lessonNumber;
        this.weekDayNumber = weekDayNumber;
        this.teacherId = teacherId;
    }

    public int getWeekNumber() {
        return weekNumber;
    }
    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getWeekDayNumber() {
        return weekDayNumber;
    }
    public void setWeekDayNumber(int weekDayNumber) {
        this.weekDayNumber = weekDayNumber;
    }

    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
