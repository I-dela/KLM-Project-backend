package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.repositories.RequestRepositoryJpa;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

    @Autowired
    RequestRepository requestRepositoryJpa;

    @GetMapping("/")
    public List<Request> getRequests() {
        return (List<Request>) requestRepositoryJpa.findAll();
    }

    @GetMapping("/runner")
    public List<Request> getRequests(@RequestHeader(name = "RUNID") int runnerId) {
        System.out.println("==================================");
        List<Request> requestList = requestRepositoryJpa.findRunnerAcceptedRequests(runnerId);
        System.out.println(requestList);
        return requestList;
    }

    @GetMapping("/{id}")
    public Request getRequest(@PathVariable String id) {
        return requestRepositoryJpa.findById(id);
    }

    @PostMapping("/")
    public Request postRequest(@RequestBody @Valid Request request, @RequestHeader(name = "GEID") int userId) {
        System.out.println(request);
        return requestRepositoryJpa.save(request, userId);
    }

    @PutMapping("/{id}/set-status")
    public void changeRequestStatus(@PathVariable String id, @RequestParam(name = "status") Request.Status status) {
        System.out.println(id);
        requestRepositoryJpa.setRequestStatus(id, status);
    }

    @GetMapping("/by")
    public List<Request> getRequestsByStatus(@RequestParam(name = "status") Request.Status status) {
        return requestRepositoryJpa.findRequestsByStatus(status);
    }

    @PostMapping("/accepted")
    public void acceptRequest(@RequestBody Request request, @RequestHeader(name = "RUNID") int userId) {
        System.out.println(userId);
        System.out.println(request);
        requestRepositoryJpa.addRunnerToRequest(request, userId);
    }

}
