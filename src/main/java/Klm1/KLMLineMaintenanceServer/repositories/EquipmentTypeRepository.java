package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class EquipmentTypeRepository  {

    @Autowired
    EntityManager entityManager;

    public List<EquipmentType> findAll(){
        TypedQuery<EquipmentType> query= entityManager.createQuery("select et from EquipmentType et", EquipmentType.class);

        return query.getResultList();
    }

    public void save(EquipmentType equipmentType){

    }


    public EquipmentType deleteById(int id){
        return null;
    }



}
