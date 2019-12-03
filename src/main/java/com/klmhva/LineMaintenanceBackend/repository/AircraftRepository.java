package com.klmhva.LineMaintenanceBackend.repository;

import com.klmhva.LineMaintenanceBackend.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, String> {
}
