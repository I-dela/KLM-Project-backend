package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
  private List<Request> requests;
  @Id
  private String location;

  @Enumerated(EnumType.STRING)
  private Type type;


  public Location(){

  }


  public Location(String location, Type type) {
    this.location = location;
    this.type = type;
  }

  enum Type
  {
    Pier,Buffer
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}


