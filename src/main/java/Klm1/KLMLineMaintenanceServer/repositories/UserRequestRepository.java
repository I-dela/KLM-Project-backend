package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.UserRequest;
import org.springframework.data.repository.CrudRepository;

public interface UserRequestRepository extends CrudRepository<UserRequest, UserRequest.UrequestCPK> {
}
