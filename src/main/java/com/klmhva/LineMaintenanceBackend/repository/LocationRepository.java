package com.klmhva.LineMaintenanceBackend.repository;

import com.klmhva.LineMaintenanceBackend.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {
}
