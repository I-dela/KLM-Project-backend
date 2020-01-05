package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentRepository;
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

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("/requests")
    public List<Request> getRequests() {

        return (List<Request>) requestRepository.findAll();
    }

    @GetMapping("/requests/runner")
    public List<Request> getRequests(@RequestHeader(name = "RUNID") String userId) {
        List<Request> requestList = requestRepository.findRunnerAcceptedRequests(userId);
        return requestList;
    }

    @GetMapping("/requests/user-created")
    public List<Request> getRequestsByEngineer(@RequestHeader(name = "GEID") String userId) {
        List<Request> requestList = requestRepository.findByEngineerCreatedRequests(userId);
        return requestList;
    }

    @GetMapping("/requests/user-created/by")
    public List<Request> getRequestsByEngineer(@RequestHeader(name = "GEID") String userId, @RequestParam(name = "status") Request.Status status) {
        List<Request> requestList = requestRepository.findByEngineerCreatedRequests(userId);
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
        return requestRepository.findById(id);
    }

    @GetMapping("/requests/departure")
    public List<Request> getRequestsOrderByDeparture(){
        return requestRepository.find_requests_order_by_departure();
    }

    @PostMapping("/requests")
    public Request postRequest(@RequestBody @Valid Request request, @RequestHeader(name = "GEID") String userId) {
        System.out.println(request);
        System.out.println(userId);
        return requestRepository.save(request, userId);
    }

    @PostMapping("/requests/self")
    public Request postSelfPickupRequest(@RequestBody @Valid Request request, @RequestHeader(name = "GEID") String userId) {
        System.out.println(request);
        System.out.println(userId);
        return requestRepository.saveSelfPickup(request, userId);
    }

    @GetMapping("/requests/self")
    public List<Request> getSelfPickupRequest(@RequestHeader(name = "GEID") String userId) {
        System.out.println(userId);
        return requestRepository.findSelfPickupList(userId);
    }

    @PutMapping("/requests/{id}/set-status")
    public void changeRequestStatus(@PathVariable String id, @RequestParam(name = "status") Request.Status status) {
        System.out.println(id);
        requestRepository.setRequestStatus(id, status);
    }

    @PutMapping("/requests/changeEquipment")
    public ResponseEntity<Object> changeEquipment(@RequestBody Request request){

        Request request1 = requestRepository.findById(request.getId());

        Equipment equipment = equipmentRepository.findById(request.getEquipment().getSerialNumber());

        requestRepository.setRequestEquipment(request1, equipment);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/requests/by")
    public List<Request> getRequestsByStatus(@RequestParam(name = "status") Request.Status status) {
        return requestRepository.findRequestsByStatus(status);
    }

    @PostMapping("/requests/accepted")
    public void acceptRequest(@RequestBody Request request, @RequestHeader(name = "RUNID") String userId) {
        requestRepository.addRunnerToRequest(request, userId);
    }

    @PutMapping("/requests/confirm-delivery")
    public void closeRequestDelivery(@RequestBody String requestId) {
        requestRepository.closeRequestDelivery(requestId);
    }
}
