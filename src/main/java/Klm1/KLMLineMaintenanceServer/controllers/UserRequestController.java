package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.UserRequest;
import Klm1.KLMLineMaintenanceServer.repositories.UserRequestRepositoryJpa;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRequestController {

    @Autowired
    private UserRequestRepository userRequestRepositoryJpa;

    @GetMapping("/userRequests")
    public List<UserRequest> getUserRequests() {
        return (List<UserRequest>) userRequestRepositoryJpa.findAll();
    }

}
