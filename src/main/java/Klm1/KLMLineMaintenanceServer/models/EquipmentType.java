package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {

  @OneToMany(fetch = FetchType.LAZY , mappedBy = "equipmentType")
  private List<Request> requests;

  @Id
  @Column(name = "id")
  private int id ;

  @Column(name = "naam")
  private String naam;


  public EquipmentType(){

  }

  public EquipmentType(String naam) {
    this.naam = naam;
  }


  public int getId() {
    return id;
  }


  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    this.naam = naam;
  }




}
