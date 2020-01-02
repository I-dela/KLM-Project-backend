package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentTypeRepositoryJpa;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.EquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eType")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentTypeController {

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepositoryJpa;


    @GetMapping("/getType")
    public List<EquipmentType> getType() {
        System.out.println(equipmentTypeRepositoryJpa.findAll());
        return (List<EquipmentType>) equipmentTypeRepositoryJpa.findAll();
    }

    @PostMapping(value = "/postType")
    public String postType(@RequestBody EquipmentType equipmentType) {

        equipmentTypeRepositoryJpa.save(equipmentType);

        return "saved succesfully";
    }

    @PutMapping(value = "/updateType")
    public String updateType(@RequestBody EquipmentType equipmentType) {

        equipmentTypeRepositoryJpa.save(equipmentType);

        return "updated successfully";

    }

    @DeleteMapping(value = "/deleteType/{id}")
    public String deleteType(@PathVariable int id) {

        equipmentTypeRepositoryJpa.deleteById(id);

        return "Delete is successfull";
    }

}
