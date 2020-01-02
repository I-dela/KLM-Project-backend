package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.UserRequest;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRequestRepositoryJpa implements UserRequestRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<UserRequest> findAll(){
        TypedQuery<UserRequest> query= em.createQuery("select ur from UserRequest ur", UserRequest.class);

        return query.getResultList();
    }
}
