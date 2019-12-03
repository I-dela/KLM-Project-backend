package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;


@Entity
@Table(name = "User")
public class User {
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

  public User( String name, Role role, String password) {
    this.name = name;
    this.role = role;
    this.password= password;
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



  @Override
  public String toString() {
    return this.name;
  }



}



