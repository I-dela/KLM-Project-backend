package Klm1.KLMLineMaintenanceServer.repositories.security;

import Klm1.KLMLineMaintenanceServer.models.User;

public class JWTokenInfo {
  public static final String KEY = "tokenInfo";

  private String id;
  private String role;


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }





}