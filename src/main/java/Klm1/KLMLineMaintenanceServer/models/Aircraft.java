package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
    private List<Request> requests;

    @Id
    private int id;


    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;


    private String manufacturer;


    public Aircraft() {

    }


    public Aircraft(int id, String name, Type type, String manufacturer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
    }
  enum Type {
    NA, Wide_body, Narrow_body
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }


  public void setType(Type type) {
    this.type = type;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
}




