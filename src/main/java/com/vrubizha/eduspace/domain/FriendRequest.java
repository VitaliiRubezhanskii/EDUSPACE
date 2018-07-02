package com.vrubizha.eduspace.domain;

import com.vrubizha.eduspace.domain.converters.AccountConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "friend_request")
public class FriendRequest implements Serializable {

    private int requestId;

    private Account account;
    private Date timeOfRequest;
    private String status;
    private Set<Account> accounts;

    public FriendRequest() {
    }

    public FriendRequest(int requestId, Account account,
                         Timestamp timeOfRequest, String status,Set<Account> accounts) {
        this.requestId = requestId;
        this.account= account;
        this.timeOfRequest = timeOfRequest;
        this.status = status;
        this.accounts=accounts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    public int getRequestId() {
        return requestId;
    }
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Column
    @Convert(converter = AccountConverter.class)
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    @Column(name = "time_of_request")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimeOfRequest() {
        return timeOfRequest;
    }
    public void setTimeOfRequest(Date timeOfRequest) {
        this.timeOfRequest = timeOfRequest;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "account_friendrequest", joinColumns = {
            @JoinColumn(name = "request_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "account_id",
                    nullable = false, updatable = false) })
    public Set<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
