package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

    @Autowired
    RequestRepository requestRepository;


    @GetMapping("/")
    public List<Request> getRequests () {
        return (List<Request>) requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Request getRequest(@PathVariable String id){
        return requestRepository.findById(id).orElse(null);
    }
}
