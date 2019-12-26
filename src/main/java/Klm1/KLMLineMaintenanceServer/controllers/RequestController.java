package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Equipment;
import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.models.User;
import Klm1.KLMLineMaintenanceServer.repositories.EquipmentRepository;
import Klm1.KLMLineMaintenanceServer.repositories.RequestRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<Request> getRequests(@RequestHeader(name = "RUNID") int runnerId) {
        System.out.println("==================================");
        List<Request> requestList = requestRepository.findRunnerAcceptedRequests(runnerId);
        System.out.println(requestList);
        return requestList;
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
    public Request postRequest(@RequestBody @Valid Request request, @RequestHeader(name = "GEID") int userId) {
        System.out.println(request);
        return requestRepository.save(request, userId);
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
    public void acceptRequest(@RequestBody Request request, @RequestHeader(name = "RUNID") int userId) {
        System.out.println(userId);
        System.out.println(request);
        requestRepository.addRunnerToRequest(request, userId);
    }



}
