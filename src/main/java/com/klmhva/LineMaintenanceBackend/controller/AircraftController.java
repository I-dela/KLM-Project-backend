package com.klmhva.LineMaintenanceBackend.controller;

import com.klmhva.LineMaintenanceBackend.model.Aircraft;
import com.klmhva.LineMaintenanceBackend.model.Equipment;
import com.klmhva.LineMaintenanceBackend.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping("/")
    public List<String> getAircraftTypes() {
        List<String> aircraftTypes = new ArrayList<>();
        List<Aircraft> aircraftList = (List<Aircraft>) aircraftRepository.findAll();
        aircraftList.forEach(aircraft -> {
            String aircraftType = aircraft.getType();

            if (!aircraftTypes.contains(aircraftType)) {
                aircraftTypes.add(aircraftType);
            }
        });
        return aircraftTypes;
    }
}
