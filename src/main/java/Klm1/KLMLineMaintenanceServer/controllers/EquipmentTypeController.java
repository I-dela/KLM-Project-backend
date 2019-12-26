package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentTypeController {

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;


    @GetMapping("/equipmentType/")
    public List<EquipmentType> getType() {
        System.out.println(equipmentTypeRepository.findAll());
        return (List<EquipmentType>) equipmentTypeRepository.findAll();
    }

    @PostMapping(value = "/equipmentType/")
    public String postType(@RequestBody EquipmentType equipmentType) {

        equipmentTypeRepository.save(equipmentType);

        return "saved succesfully";
    }

    @PutMapping(value = "/equipmentType/")
    public String updateType(@RequestBody EquipmentType equipmentType) {

        equipmentTypeRepository.save(equipmentType);

        return "updated successfully";

    }

    @DeleteMapping(value = "/equipmentType/{id}")
    public String deleteType(@PathVariable int id) {

        equipmentTypeRepository.deleteById(id);

        return "Delete is successfull";
    }

}
