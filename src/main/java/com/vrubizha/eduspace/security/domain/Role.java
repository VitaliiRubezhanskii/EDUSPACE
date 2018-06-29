package com.vrubizha.eduspace.security.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements Serializable {


    private int id;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


}
