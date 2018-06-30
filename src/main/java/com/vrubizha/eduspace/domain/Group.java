package com.vrubizha.eduspace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "interestgroups")
public class Group implements Serializable {

    private int groupId;
    private String  groupName;
    private String groupInfo;
    private Set<Student> students;

    public Group() {
    }

    public Group(int groupId, String groupName, String groupInfo,
                 Set<Student> students) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupInfo = groupInfo;
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="group_id")
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name = "group_info")
    public String getGroupInfo() {
        return groupInfo;
    }
    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
