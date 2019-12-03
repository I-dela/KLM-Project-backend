package com.klmhva.LineMaintenanceBackend.repository;

import com.klmhva.LineMaintenanceBackend.model.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<Equipment, String> {
}
