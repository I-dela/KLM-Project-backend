package com.klmhva.LineMaintenanceBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

enum  Role {
    RUNNER,
    MECHANIC,
    ADMIN
}

@Entity
@Table(name = "User")
public class User {

    @Id
    private final String id;
    private String name;
    private String lastName;
    private Role role;
    private String password;

    public User(String id, String name, String lastName, Role role, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
