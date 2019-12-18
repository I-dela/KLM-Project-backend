package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentController {

  @Autowired
  private EquipmentRepository equipmentRepository;

  @GetMapping("/")
  public List<Equipment> getEquipments(){
    return(List<Equipment>) equipmentRepository.findAll();
  }

  @GetMapping("/{serialNumber}")
  public Equipment getEquipment(@PathVariable String serialNumber){
    System.out.println(equipmentRepository.findById(serialNumber));
    return equipmentRepository.findById(serialNumber);
  }

  @PostMapping("/")
  public ResponseEntity postEquipment(@RequestBody Equipment equipment){
    try {
      equipmentRepository.save(equipment);
      return ResponseEntity.status(HttpStatus.CREATED).body("Equipment with id:" + equipment.getId() + " was created");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PatchMapping("/{serialNumber}")
  public ResponseEntity updateEquipment(@PathVariable String serialNumber, @RequestBody Equipment equipment){
    Equipment equipmentOptional = equipmentRepository.findById(serialNumber);
    if (equipmentOptional != null) {
      equipmentRepository.save(equipment);
      return ResponseEntity.status(HttpStatus.OK).body("Equipment with id:" + serialNumber + " was updated");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipment with id:" + serialNumber + " could not be found");
    }
  }

  @DeleteMapping("/{serialNumber}")
  public String deleteEquipment(@PathVariable String serialNumber){
    equipmentRepository.deleteById(serialNumber);
    return "Delete is successfull";
  }

  @GetMapping("/byType")
  public List<Equipment> getEquipmentByType(@RequestParam(name = "type") String type) {
    return equipmentRepository.findRequestsByType(type);
  }

  @GetMapping("/{type}/by")
  public List<Equipment> getEquipmentByTypeAndStatus(@PathVariable int type, @RequestParam(name = "status") Equipment.Status status) {
    return equipmentRepository.findRequestsByTypeAndStatus(type, status);
  }

}
