package com.klmhva.LineMaintenanceBackend.controller;

import com.klmhva.LineMaintenanceBackend.model.Equipment;
import com.klmhva.LineMaintenanceBackend.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/getEquipment")
    public @ResponseBody
    List<Equipment> getEquipment() {
        return (List<Equipment>) equipmentRepository.findAll();
    }

    @GetMapping("/getEquipmentTypes")
    public @ResponseBody
    List<String> getEquipmentTypes() {
        List<String> equipmentTypes = new ArrayList<>();
        List<Equipment> equipmentList = (List<Equipment>) equipmentRepository.findAll();

        equipmentList.forEach(equipment -> {
            String equipmentName = equipment.getName();

            if (!equipmentTypes.contains(equipmentName)) {
                equipmentTypes.add(equipmentName);
            }
        });
        return equipmentTypes;
    }
}
