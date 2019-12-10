package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.EquipmentType;
import Klm1.KLMLineMaintenanceServer.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EquipmentRepository {
    @Autowired
    private EntityManager em;

    //  Get all
    public List<Equipment> findAll() {
        TypedQuery<Equipment> namedQuery = em.createNamedQuery("find_all_equipment", Equipment.class);
        return namedQuery.getResultList();
    }

    //  Get by id
    public Equipment findById(String id) {
        return em.find(Equipment.class, id);
    }

    //  Post
    public Equipment save(Equipment equipment) {
        return em.merge(equipment);
    }

    //  Change equipment status
    public Equipment setEquipmentStatus(String id, Equipment.Status status) {
        Equipment equipment = em.find(Equipment.class, id);
        equipment.setStatus(status);
        return em.merge(equipment);
    }

    //  Delete equipment
    public void deleteById(String id) {
        Equipment equipment = em.find(Equipment.class, id);
        em.remove(equipment);
    }

    public List<Equipment> findRequestsByType(String type) {
        TypedQuery<Equipment> namedQuery = em.createNamedQuery("find_equipment_by_type", Equipment.class);
        return namedQuery.setParameter("type", type).getResultList();
    }

    public List<Equipment> findRequestsByTypeAndStatus(int type, Equipment.Status status) {
        EquipmentType equipmentType = em.find(EquipmentType.class, type);
        TypedQuery<Equipment> namedQuery = em.createNamedQuery("find_equipment_by_type_and_status", Equipment.class);
        return namedQuery.setParameter("type", equipmentType).setParameter("status", status).getResultList();
    }
}
