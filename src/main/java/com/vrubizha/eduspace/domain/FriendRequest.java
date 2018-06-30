package com.vrubizha.eduspace.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "friend_request")
public class FriendRequest {

    private int requestId;
    private int opponentAccount;
    private Time timeOfRequest;
    private String status;
    private Set<Account> accounts;

    public FriendRequest() {
    }

    public FriendRequest(int requestId, int opponentAccount,
                         Time timeOfRequest, String status,Set<Account> accounts) {
        this.requestId = requestId;
        this.opponentAccount = opponentAccount;
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

    @Column(name = "opponent_account")
    public int getOpponentAccount() {
        return opponentAccount;
    }
    public void setOpponentAccount(int opponentAccount) {
        this.opponentAccount = opponentAccount;
    }

    @Column(name = "time_of_request")
    public Time getTimeOfRequest() {
        return timeOfRequest;
    }
    public void setTimeOfRequest(Time timeOfRequest) {
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
