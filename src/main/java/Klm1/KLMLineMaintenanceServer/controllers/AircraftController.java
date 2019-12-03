package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Aircraft;
import Klm1.KLMLineMaintenanceServer.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
@CrossOrigin(origins = "http://localhost:4200")
public class AircraftController {

  @Autowired
  private AircraftRepository aircraftRepository;


  @GetMapping("/")
  public List<Aircraft> getAircraftList(){
    return (List<Aircraft>) aircraftRepository.findAll();
  }

  @GetMapping("/{id}")
  public Aircraft getAircraft(@PathVariable int id){
    return aircraftRepository.findById(id).orElse(null);
  }

  @PostMapping("/")
  public ResponseEntity postAircraft(@RequestBody Aircraft aircraft){
    try {
      aircraftRepository.save(aircraft);
      return ResponseEntity.ok(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong posting Aircraft with id: " + aircraft.getId());
    }
  }
}
