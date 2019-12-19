package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Location;
import Klm1.KLMLineMaintenanceServer.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;


    @GetMapping("/locations")
    public List<Location> getLocation() {
        System.out.println(locationRepository.findAll());
        return (List<Location>) locationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    public Location getLocationById(@PathVariable(name = "id") String id){
        return locationRepository.findById(id);
    }

    @PostMapping(value = "/locations")
    public String postLocation(@RequestBody Location location) {

        locationRepository.save(location);
        return "saved succesfully";
    }

    @PutMapping(value = "/locations")
    public String updateLocation(@RequestBody Location location) {

        locationRepository.save(location);

        return "updated successfully";

    }

    @DeleteMapping(value = "/locations/{location}")
    public String deleteLocation(@PathVariable String location) {

        Location location1 = locationRepository.findById(location);

        locationRepository.delete(location1);

        return "Delete is successfull";
    }

}
