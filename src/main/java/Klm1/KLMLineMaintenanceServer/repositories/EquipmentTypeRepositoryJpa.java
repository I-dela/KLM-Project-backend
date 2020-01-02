package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.EquipmentTypeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class EquipmentTypeRepositoryJpa implements EquipmentTypeRepository {
    @Override
    public List<EquipmentType> findAll(){
        return null;
    }
    @Override

    public void save(EquipmentType equipmentType){

    }

    @Override

    public EquipmentType deleteById(int id){
        return null;
    }

    @Override
    public EquipmentType findById(int id) {
        return null;
    }


}
