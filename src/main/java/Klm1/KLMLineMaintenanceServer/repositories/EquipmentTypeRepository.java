package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class EquipmentTypeRepository  {

    public List<EquipmentType> findAll(){
        return null;
    }

    public void save(EquipmentType equipmentType){

    }


    public EquipmentType deleteById(int id){
        return null;
    }



}
