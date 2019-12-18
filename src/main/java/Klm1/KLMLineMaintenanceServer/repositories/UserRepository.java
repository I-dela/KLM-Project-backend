package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @Autowired
    private EntityManager em;

    public List<User> findAll(){
        TypedQuery<User> query= em.createQuery("select u from User u", User.class);

        return query.getResultList();
    }

    public User findById(String id){

      return em.find(User.class, id);

    }

    public void delete(User user){
        User toRemove = em.merge(user);

        em.remove(toRemove);
    }

    public User save(User user){
       return em.merge(user);
    }
}
