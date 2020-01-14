package Klm1.KLMLineMaintenanceServer.repositories.security;

public class JWTokenInfo {
  public static final String KEY = "tokenInfo";

  private String userId;
  private String name;
  private String role;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
