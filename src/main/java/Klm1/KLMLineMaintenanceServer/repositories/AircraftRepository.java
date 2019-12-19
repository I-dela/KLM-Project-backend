package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Aircraft;
import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AircraftRepository {

    public List<Aircraft> findAll(){
        return null;
    }


    public void save(Aircraft aircraft){

    }
    public Aircraft findById(int id){
        return null;
    }
}
