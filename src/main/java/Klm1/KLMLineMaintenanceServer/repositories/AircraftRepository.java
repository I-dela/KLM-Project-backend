package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Aircraft;
import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AircraftRepository {

    @Autowired
    EntityManager entityManager;

    public List<Aircraft> findAll(){

        TypedQuery<Aircraft> query= entityManager.createQuery("select  a from Aircraft a", Aircraft.class);
      return query.getResultList();
    }


    public void save(Aircraft aircraft){

    }
    public Aircraft findById(int id){
        return null;
    }
}
