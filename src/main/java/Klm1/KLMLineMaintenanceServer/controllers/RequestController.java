package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentRepositoryJpa;
import Klm1.KLMLineMaintenanceServer.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

    //  TODO User depended requests needs to go through userRequest instead

    @Autowired
    RequestRepository requestRepositoryJpa;

    @Autowired
    EquipmentRepositoryJpa equipmentRepositoryJpa;

    @GetMapping("/requests")
    public List<Request> getRequests() {

        return (List<Request>) requestRepositoryJpa.findAll();
    }

    @GetMapping("/requests/runner")
    public List<Request> getRequests(@RequestHeader(name = "userId") String userId) {
        List<Request> requestList = requestRepositoryJpa.findRunnerAcceptedRequests(userId);
        return requestList;
    }

    @GetMapping("/requests/user-created")
    public List<Request> getRequestsByEngineer(@RequestHeader(name = "userId") String userId) {
        List<Request> requestList = requestRepositoryJpa.findByEngineerCreatedRequests(userId);
        return requestList;
    }

    @GetMapping("/requests/user-created/by")
    public List<Request> getRequestsByEngineer(@RequestHeader(name = "userId") String userId, @RequestParam(name = "status") Request.Status status) {
        List<Request> requestList = requestRepositoryJpa.findByEngineerCreatedRequests(userId);
        List<Request> filteredRequestList = new ArrayList<>();
        requestList.forEach(request -> {
            if (request.getStatus() == status) {
                filteredRequestList.add(request);
            }
        });
        return filteredRequestList;
    }

    @GetMapping("/requests/{id}")
    public Request getRequest(@PathVariable String id) {
        return requestRepositoryJpa.findById(id);
    }

    @GetMapping("/requests/departure")
    public List<Request> getRequestsOrderByDeparture(){
        return requestRepositoryJpa.find_requests_order_by_departure();
    }

    @PostMapping("/requests")
    public Request postRequest(@RequestBody @Valid Request request, @RequestHeader(name = "userId") String userId) {
        System.out.println(userId);
        return requestRepositoryJpa.save(request, userId);
    }

    @PostMapping("/requests/self")
    public Request postSelfPickupRequest(@RequestBody @Valid Request request, @RequestHeader(name = "userId") String userId) {
        return requestRepositoryJpa.saveSelfPickup(request, userId);
    }

    @PutMapping("/requests/self-close")
    public Request closeSelfPickupRequest(@RequestBody @Valid String requestId, @RequestHeader(name = "userId") String userId) {
        return requestRepositoryJpa.closeSelfPickUp(requestId, userId);
    }

    @GetMapping("/requests/self")
    public List<Request> getSelfPickupRequest(@RequestHeader(name = "userId") String userId) {
        return requestRepositoryJpa.findSelfPickupList(userId);
    }

    @PutMapping("/requests/{id}/set-status")
    public void changeRequestStatus(@PathVariable String id, @RequestParam(name = "status") Request.Status status) {
        requestRepositoryJpa.setRequestStatus(id, status);
    }

    @PutMapping("/requests/changeEquipment")
    public ResponseEntity<Object> changeEquipment(@RequestBody Request request){
        Request request1 = requestRepositoryJpa.findById(request.getId());
        Equipment equipment = equipmentRepositoryJpa.findById(request.getEquipment().getSerialNumber());
        requestRepositoryJpa.setRequestEquipment(request1, equipment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/requests/by")
    public List<Request> getRequestsByStatus(@RequestParam(name = "status") Request.Status status) {
        return requestRepositoryJpa.findRequestsByStatus(status);
    }

    @PostMapping("/requests/accepted")
    public void acceptRequest(@RequestBody Request request, @RequestHeader(name = "userId") String userId) {
        requestRepositoryJpa.addRunnerToRequest(request, userId);
    }

    @PutMapping("/requests/confirm-delivery")
    public void closeRequestDelivery(@RequestBody String requestId) {
        requestRepositoryJpa.closeRequestDelivery(requestId);
    }

    @PutMapping("/requests/cancel")
    public void cancelRequest(@RequestBody String requestId) {
        requestRepositoryJpa.setRequestStatus(requestId, Request.Status.CAN);
    }

    @PutMapping("/requests/cancel-run")
    public void cancelRun(@RequestBody String requestId) {
        requestRepositoryJpa.cancelRequestRun(requestId);
    }

    @PutMapping("/requests/pick-up")
    public void requestPickUp(@RequestBody String requestId) {
        requestRepositoryJpa.requestPickUp(requestId);
    }
}
