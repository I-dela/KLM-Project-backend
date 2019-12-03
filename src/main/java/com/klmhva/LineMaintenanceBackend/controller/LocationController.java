package com.klmhva.LineMaintenanceBackend.controller;

import com.klmhva.LineMaintenanceBackend.model.Location;
import com.klmhva.LineMaintenanceBackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/getLocations")
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

}
