package com.vrubizha.eduspace.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    private int id;
    private int accountUID;
    private String priceOption;
    private String registered;
    private String status;
    private int DaysOfDuration;
    private BigInteger balance;
    private Student student;
    private Parent parent;
    private Teacher teacher;


    private Set<FriendRequest> requests;


    public Account() {
    }

    public Account(int id, int accountUID, String priceOption,
                   String status, int daysOfDuration,
                   BigInteger balance,Student student,Parent parent,Teacher teacher,
                   Set<FriendRequest> requests) {
        this.id = id;
        this.accountUID = accountUID;
        this.priceOption = priceOption;
        this.registered = new Date().toString();
        this.status = status;
        this.DaysOfDuration = daysOfDuration;
        this.balance = balance;
        this.student=student;
        this.parent=parent;
        this.teacher=teacher;
        this.requests=requests;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "accountUID")
    public int getAccountUID() {
        return accountUID;
    }
    public void setAccountUID(int accountUID) {
        this.accountUID = accountUID;
    }

    @Column(name = "price_option")
    public String getPriceOption() {
        return priceOption;
    }
    public void setPriceOption(String priceOption) {
        this.priceOption = priceOption;
    }

    @Column(name = "registered")
    public String getRegistered() {
        return registered;
    }
    public void setRegistered(String registered) {
        this.registered = registered;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "days_of_duration")
    public int getDaysOfDuration() {
        return DaysOfDuration;
    }
    public void setDaysOfDuration(int daysOfDuration) {
        DaysOfDuration = daysOfDuration;
    }

    @Column(name = "balance")
    public BigInteger getBalance() {
        return balance;
    }
    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Parent getParent() {
        return parent;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
    public Set<FriendRequest> getRequests() {
        return requests;
    }
    public void setRequests(Set<FriendRequest> requests) {
        this.requests = requests;
    }
}
