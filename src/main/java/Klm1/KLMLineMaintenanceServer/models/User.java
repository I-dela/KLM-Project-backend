package Klm1.KLMLineMaintenanceServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "User")
public class User {

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user_id")
  @JsonIgnore
  private List<UserRequest> userRequests;

  @Id
  @Column(name = "id")
  @GeneratedValue
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private Role   role;

  @Column(name = "password")
  private String password;

  public User() {
  }

  public User(List<UserRequest> userRequests, String name, Role role, String password) {
    this.userRequests = userRequests;
    this.name = name;
    this.role = role;
    this.password = password;
  }

  enum Role{
    GE, RUN, ADM
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public Role getRole() {
    return role;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<UserRequest> getUserRequests() {
    return userRequests;
  }

  public void setUserRequests(List<UserRequest> userRequests) {
    this.userRequests = userRequests;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return this.name;
  }



}



