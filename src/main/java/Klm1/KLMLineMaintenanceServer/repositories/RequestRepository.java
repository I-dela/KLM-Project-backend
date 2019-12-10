package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.models.User;
import Klm1.KLMLineMaintenanceServer.models.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RequestRepository {

    @Autowired
    private EntityManager em;

    //  Get all
    public List<Request> findAll() {
        TypedQuery<Request> namedQuery = em.createNamedQuery("find_all_requests", Request.class);
        return namedQuery.getResultList();
    }

    //  Get by id
    public Request findById(String id) {
        return em.find(Request.class, id);
    }

    //  Post
    public Request save(Request request, int userId) {
        User user = em.find(User.class, userId);
        Request request1 = em.merge(request);
        UserRequest userRequest =  new UserRequest(user, request1);

        em.merge(userRequest);
        return request1;
    }

    //  Change request status
    public Request setRequestStatus(String id, Request.Status status) {
        Request request = em.find(Request.class, id);
        request.setStatus(status);
        return em.merge(request);
    }

    //  Delete request

    //  Get Open requests
    public List<Request> findRequestsByStatus(Request.Status status) {
        TypedQuery<Request> namedQuery = em.createNamedQuery("find_requests_by_status", Request.class);
        return namedQuery.setParameter("status", status).getResultList();
    }

    public void addRunnerToRequest(Request request, int runnerId) {
        // TODO Needs to be declared in UserRequest Repository
        TypedQuery<UserRequest> namedQuery = em.createNamedQuery("find_user_request_by_request_id", UserRequest.class);

        UserRequest userRequest = namedQuery.setParameter("request", request).getSingleResult();
        userRequest.setAcceptedBy(runnerId);
        em.merge(userRequest);
        request.setStatus(Request.Status.IP);
        em.merge(request);
    }

    public List<Request> findRunnerAcceptedRequests(int runnerId) {
        TypedQuery<Request> namedQuery = em.createNamedQuery("find_all_by_runner_accepted_requests", Request.class);
        return namedQuery.setParameter("runner_id", runnerId).getResultList();
    }
}
