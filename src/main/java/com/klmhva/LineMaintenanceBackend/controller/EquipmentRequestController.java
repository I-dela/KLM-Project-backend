package com.klmhva.LineMaintenanceBackend.controller;

import com.klmhva.LineMaintenanceBackend.model.EquipmentRequest;
import com.klmhva.LineMaintenanceBackend.repository.EquipmentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/equipmentRequest")
public class EquipmentRequestController {

    @Autowired
    private EquipmentRequestRepository equipmentRequestRepository;

    @PostMapping("/postEquipmentRequest")
    public String postEquipmentRequest(EquipmentRequest equipmentRequest) {
        equipmentRequestRepository.save(equipmentRequest);
        return "Request with ID " + equipmentRequest.getId() + " was posted";
    }
}
