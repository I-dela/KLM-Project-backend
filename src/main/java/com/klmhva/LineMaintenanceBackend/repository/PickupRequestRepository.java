package com.klmhva.LineMaintenanceBackend.repository;

import com.klmhva.LineMaintenanceBackend.model.PickupRequest;
import org.springframework.data.repository.CrudRepository;

public interface PickupRequestRepository extends CrudRepository<PickupRequest, String> {
}
