package com.klmhva.LineMaintenanceBackend.repository;

import com.klmhva.LineMaintenanceBackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
