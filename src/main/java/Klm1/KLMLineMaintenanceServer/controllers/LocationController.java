package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Location;
import Klm1.KLMLineMaintenanceServer.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

  @Autowired
  private LocationRepository locationRepository;


  @GetMapping("/")
  public List<Location> getLocation() {
    System.out.println(locationRepository.findAll());
    return (List<Location>) locationRepository.findAll();
  }

  @PostMapping(value = "/")
  public String postLocation(@RequestBody Location location) {

    locationRepository.save(location);




    return  "saved succesfully";
  }

  @PutMapping(value = "/")
  public String updateLocation(@RequestBody Location location){

    locationRepository.save(location);

    return "updated successfully";

  }

  @DeleteMapping(value = "/{location}")
  public String deleteLocation(@PathVariable String location){

    locationRepository.deleteById(location);

    return "Delete is successfull";
  }

}
